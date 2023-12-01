<script setup>
import { computed, onBeforeMount, onMounted, ref, watch } from 'vue';
import NumberPicker from '../components/UI/Salary/NumberPicker.vue';
import Table from '../components/UI/Table.vue'
import Button from '../components/UI/Button.vue';

const years = ref([2023, 2022, 2021]);
const quarters = ref([1, 2, 3, 4]);
const months = ref([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]);

const selectedYear = ref(null);
const selectedQuarter = ref(null);
const selectedMonth = ref(null);

const selectYear = (val) => {
    selectedYear.value = val;
};

const selectQuarter = (val) => {
    selectedQuarter.value = val;
};

const selectMonth = (val) => {
    selectedMonth.value = val;
};

const noTimeSelected = computed(() => {
    return (selectedYear.value == null || selectedYear.value == undefined) && 
            (selectedQuarter.value == null || selectedQuarter.value == undefined) && 
            (selectedMonth.value == null || selectedMonth.value == undefined);
});

const header = ref([
    {
        content: 'Tháng',
        colWidth: 'min-w-[1rem]',
        align: 'text-center',
        key: 'month'
    },
    {
        content: 'Lương cứng',
        colWidth: 'min-w-[3rem]',
        align: 'text-center',
        key: 'fixedSalaryStr'
    },
    {
        content: 'Thưởng',
        colWidth: 'min-w-[3rem]',
        align: 'text-center',
        key: 'bonusStr'
    },
    {
        content: 'Phạt',
        colWidth: 'min-w-[3rem]',
        align: 'text-center',
        key: 'penaltyStr'
    },
    {
        content: 'Bảo hiểm',
        colWidth: 'min-w-[3rem]',
        align: 'text-center',
        key: 'insuranceStr'
    },
    {
        content: 'Thuế',
        colWidth: 'min-w-[3rem]',
        align: 'text-center',
        key: 'taxStr'
    },
    {
        content: 'Nhận',
        colWidth: 'min-w-[3rem]',
        align: 'text-center',
        key: 'totalStr'
    },
]);

const data = ref(null);
let params = null
const fetchData = async () => {

    const res = await fetch(`http://localhost:8080/salary/own?${params}`, {
        method: "GET",
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${localStorage.getItem('token')}`
        },
    })
    if(res.error) {
        console.log(res.error);
    }
    const dataFetched = JSON.parse(await res.text());
    data.value = dataFetched;
};

watch([selectedYear, selectedQuarter, selectedMonth], () => {
    params = ""
    if (selectedYear.value !== null) {
        params += `year=${selectedYear.value}&`
    }
    if (selectedQuarter.value !== null) {
        params += `quarter=${selectedQuarter.value}&`
    }
    if (selectedMonth.value !== null) {
        params += `month=${selectedMonth.value}`
    }
    fetchData()
}, {immediate: false});

onBeforeMount(() => {
    selectedYear.value = years.value[0]
});

</script>

<template>
    <div class="bg-white rounded-lg shadow p-4">
        <div class="grid grid-cols-3 grid-rows-[repeat(x,max-content),1fr] gap-x-5">
            <div>
                <p class="font-bold text-sm text-slate-700 mb-1">Năm</p>
                <NumberPicker :data="selectedYear" :list="years" @bind-type="selectYear"/>
            </div>
            <div>
                <p class="font-bold text-sm text-slate-700 mb-1">Quý</p>
                <NumberPicker :list="quarters" @bind-type="selectQuarter"/>
            </div>
            <div>
                <p class="font-bold text-sm text-slate-700 mb-1">Tháng</p>
                <NumberPicker :list="months" @bind-type="selectMonth"/>
            </div>
        </div>

        <p v-if="noTimeSelected" class="text-center py-4 text-[#f34971] font-semibold text-xl">
            Chọn một thời gian cụ thể để có thể xem chi tiết lương
        </p>
        <div v-else>
            <p v-if="data == null || data.length == 0" class="text-red-500 font-semibold text-xl text-center">Không có dữ liệu</p>
            <div v-else>
                <Table
                    :header="header"
                    :data="data"
                    max-height="max-h-[20rem]"
                    name="Lương tháng"
                >
                </Table>
            </div>
        </div>
    </div>
</template>