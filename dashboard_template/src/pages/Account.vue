<script setup>
import { onBeforeMount, onMounted, ref } from 'vue';
import Button from '../components/UI/Button.vue';
import AccountCard from '../components/UI/account/AccountCard.vue';
import Pagination from '../components/UI/Pagination.vue';

const header = ref([
    {
        content: 'Tài khoản',
        colWidth: 'min-w-[10rem]',
        align: 'text-center',
        key: 'account'
    },
    {
        content: 'Tên người dùng',
        colWidth: 'min-w-[10rem]',
        align: 'text-center',
        key: 'name'
    },
]);

const page = ref(1);
const totalPage = ref(1);

const data = ref(null);
const fetchEmployeeData = async () => {
    const res = await fetch(`http://localhost:8080/user/all-account?page=${page.value}&pageSize=3`, {
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
    data.value = dataFetched.accounts;
    totalPage.value = dataFetched.pageCount;
};

const changePage = (p) => {
    page.value = p;
    fetchEmployeeData();
}

onBeforeMount(() => {
    fetchEmployeeData();
});

</script>

<template>
    <div class="w-full mt-4">
        <div class="w-full flex justify-end">
            <Button>
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-6 h-6">
                    <path d="M6.25 6.375a4.125 4.125 0 118.25 0 4.125 4.125 0 01-8.25 0zM3.25 19.125a7.125 7.125 0 0114.25 0v.003l-.001.119a.75.75 0 01-.363.63 13.067 13.067 0 01-6.761 1.873c-2.472 0-4.786-.684-6.76-1.873a.75.75 0 01-.364-.63l-.001-.122zM19.75 7.5a.75.75 0 00-1.5 0v2.25H16a.75.75 0 000 1.5h2.25v2.25a.75.75 0 001.5 0v-2.25H22a.75.75 0 000-1.5h-2.25V7.5z" />
                </svg>
                Tạo tài khoản
            </Button>
        </div>
        <div class="w-full flex flex-col items-center" v-if="data != null">
            <div class="w-full px-4 grid grid-cols-3 grid-rows-[repeat(x,max-content),1fr] gap-x-5 mb-2 mt-5">
                <span class="text-center text-sm font-bold">Tài khoản</span>
                <span class="text-center text-sm font-bold">Người dùng</span>
                <span class="text-center text-sm font-bold">Hành động</span>
            </div>
            <AccountCard v-for="item in data" :key="item.id" :acc="item" />
            <Pagination :totalPage="totalPage" :currentPage="page" @navigate="changePage" class="mt-3"/>
        </div>
    </div>
</template>