<script setup>
import { computed, onBeforeMount, onMounted, ref, watch } from 'vue';
import NumberPicker from '../components/UI/Salary/NumberPicker.vue';
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

watch([selectedYear, selectedQuarter, selectedMonth], () => {
    console.log(selectedYear.value, selectedQuarter.value, selectedMonth.value);
});

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
            123
        </div>
    </div>
</template>