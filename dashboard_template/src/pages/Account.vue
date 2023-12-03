<script setup>
import { onBeforeMount, onMounted, ref } from 'vue';
import Button from '../components/UI/Button.vue';
import AccountCard from '../components/UI/account/AccountCard.vue';
import Pagination from '../components/UI/Pagination.vue';
import Modal from '../components/UI/Modal.vue';
import ModalCard from '../components/UI/ModalCard.vue';
import IconInput from '../components/UI/IconInput.vue';
import RolePicker from '../components/UI/account/RolePicker.vue';

const confirmDialogOpened = ref(false);
const selectedAccount = ref(null);

const accountModalOpened = ref(false);
const handlingAccount = ref({ id: null, account: null, name: null, role: null });

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

const deleteAccount = (account)  => {
    selectedAccount.value = account;
    confirmDialogOpened.value = true;
}

const editAccount = (account)  => {
    selectedAccount.value = {...account};
    handlingAccount.value = {...account};
    accountModalOpened.value = true;
}

const pickRole = (val) => {
    handlingAccount.value.role = val;
}

const callDeleteAccountApi = async () => {
    const res = await fetch(`http://localhost:8080/user/delete-account?userId=${selectedAccount.value.id}`, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${localStorage.getItem('token')}`
        },
    })
    if(res.error) {
        console.log(res.error);
    }
    confirmDialogOpened.value = false;
    fetchEmployeeData();
}

const closeDialog = () => {
    confirmDialogOpened.value = false;
    selectedAccount.value = null;
}

const closeAccModal = () => {
    accountModalOpened.value = false;
    selectedAccount.value = null;
}

const generatePassword = () => {
    handlingAccount.value.password = (Math.random() + 1).toString(36).substring(7);
}

const callEditAccountApi = async () => {
    const res = await fetch(`http://localhost:8080/user/edit-account`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${localStorage.getItem('token')}`
        },
        body: JSON.stringify({
            id: handlingAccount.value.id,
            username: handlingAccount.value.account,
            password: handlingAccount.value.password,
            role: handlingAccount.value.role
        })
    })
    if(res.status == 200) {
        accountModalOpened.value = false;
        fetchEmployeeData();
    }
}

const callAddAccountApi = async () => {
    const res = await fetch(`http://localhost:8080/user/add`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${localStorage.getItem('token')}`
        },
        body: JSON.stringify({
            username: handlingAccount.value.account,
            password: handlingAccount.value.password,
            role: handlingAccount.value.role
        })
    })
    if(res.status == 200) {
        accountModalOpened.value = false;
        fetchEmployeeData();
    }
}

onBeforeMount(() => {
    fetchEmployeeData();
});

</script>

<template>
    <div class="w-full mt-4">
        <div class="w-full flex justify-end">
            <Button @click="accountModalOpened = true">
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
            <AccountCard v-for="item in data" :key="item.id" :acc="item" @deleteAccount="deleteAccount" @editAccount="editAccount" />
            <Pagination :totalPage="totalPage" :currentPage="page" @navigate="changePage" class="mt-3"/>
        </div>
        <Modal :condition="confirmDialogOpened" @exit-modal="closeDialog()">
            <ModalCard @exit-modal="closeDialog()" class="max-w-4xl rounded-lg shadow">
                <template #title>
                    <p class="text-center text-3xl font-semibold">Thông báo</p>
                </template>
                <template #body>
                    <div class="max-h-96">
                        <p class="mt-4">Bạn chắc chắn muốn xóa tài khoản <b>{{ selectedAccount.account }}</b> chứ</p>
                        <div class="flex items-center justify-center space-x-4 mt-4">
                            <svg @click="callDeleteAccountApi()" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-8 h-8 p-1 text-[#39c0c8] cursor-pointer rounded-full transition-colors hover:bg-[#39c0c8]/20">
                                <path fill-rule="evenodd" d="M19.916 4.626a.75.75 0 01.208 1.04l-9 13.5a.75.75 0 01-1.154.114l-6-6a.75.75 0 011.06-1.06l5.353 5.353 8.493-12.739a.75.75 0 011.04-.208z" clip-rule="evenodd" />
                            </svg>
                            <svg @click="closeDialog()" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-8 h-8 p-1 text-[#f34971] cursor-pointer rounded-full transition-colors hover:bg-[#f34971]/20">
                                <path fill-rule="evenodd" d="M5.47 5.47a.75.75 0 011.06 0L12 10.94l5.47-5.47a.75.75 0 111.06 1.06L13.06 12l5.47 5.47a.75.75 0 11-1.06 1.06L12 13.06l-5.47 5.47a.75.75 0 01-1.06-1.06L10.94 12 5.47 6.53a.75.75 0 010-1.06z" clip-rule="evenodd" />
                            </svg>
                        </div>
                    </div>
                </template>
            </ModalCard>
        </Modal>
        <Modal :condition="accountModalOpened" @exit-modal="closeAccModal()">
            <ModalCard @exit-modal="closeAccModal()" class="rounded-lg shadow w-[32rem]">
                <template #title>
                    <p class="text-center text-3xl font-semibold" v-if="selectedAccount != null">Chỉnh sửa tài khoản</p>
                    <p class="text-center text-3xl font-semibold" v-else >Tạo tài khoản</p>
                </template>
                <template #body>
                    <div class="max-h-96 mt-4 space-y-4 px-4 pb-4">
                        <IconInput v-model="handlingAccount.account" borderColor="blue">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-6 h-6">
                                <path fill-rule="evenodd" d="M7.5 6a4.5 4.5 0 119 0 4.5 4.5 0 01-9 0zM3.751 20.105a8.25 8.25 0 0116.498 0 .75.75 0 01-.437.695A18.683 18.683 0 0112 22.5c-2.786 0-5.433-.608-7.812-1.7a.75.75 0 01-.437-.695z" clip-rule="evenodd" />
                            </svg>
                        </IconInput>
                        <RolePicker @emitBindType="pickRole" :role="handlingAccount.role"/>
                        <div class="flex items-center justify-between space-x-4">
                            <Button @click="generatePassword()">
                                <p v-if="selectedAccount != null" class="text-center w-full">Sửa mật khẩu</p>
                                <p v-else class="text-center w-full">Tạo mật khẩu</p>
                            </Button>
                            <span class="px-4 rounded-full text-white bg-[#52a1f5]">{{ handlingAccount.password }}</span>
                        </div>
                        <Button v-if="selectedAccount != null" @click="callEditAccountApi()" bgColor="success" class="w-full">
                            <p class="text-center w-full">Cập nhật tài khoản</p>
                        </Button>
                        <Button v-else @click="callAddAccountApi()" bgColor="success" class="w-full">
                            <p class="text-center w-full">Tạo tài khoản</p>
                        </Button>
                    </div>
                </template>
            </ModalCard>
        </Modal>
    </div>
</template>
