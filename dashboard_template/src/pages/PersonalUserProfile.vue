<script setup>
import { onMounted, ref, watch } from 'vue';
import img from '../assets/person.svg';
import Button from '../components/UI/Button.vue'
import IconInput from '../components/UI/IconInput.vue'

const data = ref(null);
const modifyData = ref({
    dobStr: ''
});
const modifying = ref(false);
const regex = /^\d{2}[/]\d{2}[/]\d{4}$/gm;
const invalidDob = ref(false);
const modifySuccessfully = ref(false);

const fetchData = async () => {
    const res = await fetch("http://localhost:8080/user/get-self", {
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
    modifyData.value = {...dataFetched};
};

const sendModify = async () => {
    const res = await fetch("http://localhost:8080/user/modify-self", {
        method: "PUT",
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${localStorage.getItem('token')}`
        },
        body: JSON.stringify({
            userId: data.value.id,
            address: modifyData.value.address,
            dob: modifyData.value.dobStr,
            gmail: modifyData.value.gmail
        })
    })

    if (res.error) {
        console.log(res.error);
    }
    const dataFetched = JSON.parse(await res.text());
    modifySuccessfully.value = true;
    data.value = dataFetched;
    modifyData.value = {...dataFetched};
};

const cancelModifying = () => {
    modifying.value = false;
    modifySuccessfully.value = false;
    modifyData.value = {...data.value};
}

onMounted(() => {
    fetchData();
});

watch(() => modifyData.value.dobStr, () => {
    if (regex.exec(modifyData.value.dobStr) === null) {
        invalidDob.value = true;
    } else {
        invalidDob.value = false;
    }
});

</script>

<template>
    <div v-if="data != null" class="w-full py-4">
        <div class="w-full flex items-start space-x-6">
            <img :src="img" alt="" class="w-40 max-sm:w-24 rounded-full shadow"/>
            <div class="space-y-2 w-full">
                <div class="w-full">
                    <div class="w-full">
                        <div class="w-full flex max-sm:flex-col sm:justify-between max-sm:space-y-2">
                            <p class="font-semibold text-3xl max-sm:text-2xl text-gray-600">{{ data.name }}</p>
                            <Button @click="modifying = true" class="h-fit w-fit" border-radius="full" bg-color="success" padding="px-4 py-2 max-sm:px-2">
                                <p class="max-sm:hidden mr-2">Sửa hồ sơ</p>
                                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                                    <path stroke-linecap="round" stroke-linejoin="round" d="M16.862 4.487l1.687-1.688a1.875 1.875 0 112.652 2.652L10.582 16.07a4.5 4.5 0 01-1.897 1.13L6 18l.8-2.685a4.5 4.5 0 011.13-1.897l8.932-8.931zm0 0L19.5 7.125M18 14v4.75A2.25 2.25 0 0115.75 21H5.25A2.25 2.25 0 013 18.75V8.25A2.25 2.25 0 015.25 6H10" />
                                </svg>
                            </Button>
                        </div>
                        <div class="grid grid-cols-3 grid-rows-[repeat(x,max-content),1fr] py-6 gap-y-8">
                            <div class="flex items-center space-x-1 text-[#1d1d1d]">
                                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6 max-sm:w-4 max-sm:h-4 text-[#52a1f5]">
                                    <path stroke-linecap="round" stroke-linejoin="round" d="M15 10.5a3 3 0 11-6 0 3 3 0 016 0z" />
                                    <path stroke-linecap="round" stroke-linejoin="round" d="M19.5 10.5c0 7.142-7.5 11.25-7.5 11.25S4.5 17.642 4.5 10.5a7.5 7.5 0 1115 0z" />
                                </svg>
                                <p class="w-fit max-sm:text-sm">{{ data.address }}</p>
                            </div>
                            <div class="flex items-center space-x-1 text-[#1d1d1d]">
                                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6 max-sm:w-4 max-sm:h-4 text-[#52a1f5]">
                                    <path stroke-linecap="round" stroke-linejoin="round" d="M12 8.25v-1.5m0 1.5c-1.355 0-2.697.056-4.024.166C6.845 8.51 6 9.473 6 10.608v2.513m6-4.87c1.355 0 2.697.055 4.024.165C17.155 8.51 18 9.473 18 10.608v2.513m-3-4.87v-1.5m-6 1.5v-1.5m12 9.75l-1.5.75a3.354 3.354 0 01-3 0 3.354 3.354 0 00-3 0 3.354 3.354 0 01-3 0 3.354 3.354 0 00-3 0 3.354 3.354 0 01-3 0L3 16.5m15-3.38a48.474 48.474 0 00-6-.37c-2.032 0-4.034.125-6 .37m12 0c.39.049.777.102 1.163.16 1.07.16 1.837 1.094 1.837 2.175v5.17c0 .62-.504 1.124-1.125 1.124H4.125A1.125 1.125 0 013 20.625v-5.17c0-1.08.768-2.014 1.837-2.174A47.78 47.78 0 016 13.12M12.265 3.11a.375.375 0 11-.53 0L12 2.845l.265.265zm-3 0a.375.375 0 11-.53 0L9 2.845l.265.265zm6 0a.375.375 0 11-.53 0L15 2.845l.265.265z" />
                                </svg>
                                <p class="w-fit max-sm:text-sm">{{ data.dobStr }}</p>
                            </div>
                            <div class="flex items-center space-x-1 text-[#1d1d1d]">
                                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6 max-sm:w-4 max-sm:h-4 text-[#52a1f5]">
                                    <path stroke-linecap="round" stroke-linejoin="round" d="M21.75 6.75v10.5a2.25 2.25 0 01-2.25 2.25h-15a2.25 2.25 0 01-2.25-2.25V6.75m19.5 0A2.25 2.25 0 0019.5 4.5h-15a2.25 2.25 0 00-2.25 2.25m19.5 0v.243a2.25 2.25 0 01-1.07 1.916l-7.5 4.615a2.25 2.25 0 01-2.36 0L3.32 8.91a2.25 2.25 0 01-1.07-1.916V6.75" />
                                </svg>
                                <p class="w-fit max-sm:text-sm">{{ data.gmail }}</p>
                            </div>
                            <div class="flex items-center space-x-1 text-[#1d1d1d]">
                                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6 max-sm:w-4 max-sm:h-4 text-[#52a1f5]">
                                    <path stroke-linecap="round" stroke-linejoin="round" d="M12 6v12m-3-2.818l.879.659c1.171.879 3.07.879 4.242 0 1.172-.879 1.172-2.303 0-3.182C13.536 12.219 12.768 12 12 12c-.725 0-1.45-.22-2.003-.659-1.106-.879-1.106-2.303 0-3.182s2.9-.879 4.006 0l.415.33M21 12a9 9 0 11-18 0 9 9 0 0118 0z" />
                                </svg>
                                <p class="w-fit max-sm:text-sm">{{ data.salaryStr }}</p>
                            </div>
                            <div class="flex items-center space-x-1 text-[#1d1d1d]">
                                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6 max-sm:w-4 max-sm:h-4 text-[#52a1f5]">
                                    <path stroke-linecap="round" stroke-linejoin="round" d="M9 17.25v1.007a3 3 0 01-.879 2.122L7.5 21h9l-.621-.621A3 3 0 0115 18.257V17.25m6-12V15a2.25 2.25 0 01-2.25 2.25H5.25A2.25 2.25 0 013 15V5.25m18 0A2.25 2.25 0 0018.75 3H5.25A2.25 2.25 0 003 5.25m18 0V12a2.25 2.25 0 01-2.25 2.25H5.25A2.25 2.25 0 013 12V5.25" />
                                </svg>
                                <p class="w-fit max-sm:text-sm">{{ data.department.fullDepartmentName }}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div v-if="modifying" class="w-full bg-white rounded-md p-4 shadow mt-6">
            <p class="text-center font-semibold text-lg mb-6">Chỉnh sửa hồ sơ</p>
            <div class="w-full grid grid-cols-3 grid-rows-[repeat(x,max-content),1fr gap-x-4">
                <IconInput v-model="modifyData.address" border-color="blue">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6 text-[#52a1f5]">
                        <path stroke-linecap="round" stroke-linejoin="round" d="M15 10.5a3 3 0 11-6 0 3 3 0 016 0z" />
                        <path stroke-linecap="round" stroke-linejoin="round" d="M19.5 10.5c0 7.142-7.5 11.25-7.5 11.25S4.5 17.642 4.5 10.5a7.5 7.5 0 1115 0z" />
                    </svg>
                </IconInput>
                <IconInput v-model="modifyData.dobStr" border-color="blue">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6 max-sm:w-4 max-sm:h-4 text-[#52a1f5]">
                        <path stroke-linecap="round" stroke-linejoin="round" d="M12 8.25v-1.5m0 1.5c-1.355 0-2.697.056-4.024.166C6.845 8.51 6 9.473 6 10.608v2.513m6-4.87c1.355 0 2.697.055 4.024.165C17.155 8.51 18 9.473 18 10.608v2.513m-3-4.87v-1.5m-6 1.5v-1.5m12 9.75l-1.5.75a3.354 3.354 0 01-3 0 3.354 3.354 0 00-3 0 3.354 3.354 0 01-3 0 3.354 3.354 0 00-3 0 3.354 3.354 0 01-3 0L3 16.5m15-3.38a48.474 48.474 0 00-6-.37c-2.032 0-4.034.125-6 .37m12 0c.39.049.777.102 1.163.16 1.07.16 1.837 1.094 1.837 2.175v5.17c0 .62-.504 1.124-1.125 1.124H4.125A1.125 1.125 0 013 20.625v-5.17c0-1.08.768-2.014 1.837-2.174A47.78 47.78 0 016 13.12M12.265 3.11a.375.375 0 11-.53 0L12 2.845l.265.265zm-3 0a.375.375 0 11-.53 0L9 2.845l.265.265zm6 0a.375.375 0 11-.53 0L15 2.845l.265.265z" />
                    </svg>
                </IconInput>
                <IconInput type="email" v-model="modifyData.gmail" border-color="blue">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6 max-sm:w-4 max-sm:h-4 text-[#52a1f5]">
                        <path stroke-linecap="round" stroke-linejoin="round" d="M21.75 6.75v10.5a2.25 2.25 0 01-2.25 2.25h-15a2.25 2.25 0 01-2.25-2.25V6.75m19.5 0A2.25 2.25 0 0019.5 4.5h-15a2.25 2.25 0 00-2.25 2.25m19.5 0v.243a2.25 2.25 0 01-1.07 1.916l-7.5 4.615a2.25 2.25 0 01-2.36 0L3.32 8.91a2.25 2.25 0 01-1.07-1.916V6.75" />
                    </svg>
                </IconInput>
            </div>
            <span v-if="invalidDob" class="text-[#f34971] font-semibold text-sm">Ngày sinh không hợp lệ</span>
            
            <div class="w-full flex items-end">
                <div v-if="modifySuccessfully" class="flex items-center text-[#39c0c8] font-semibold space-x-1">
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" stroke-width="1.75" fill="currentColor" class="w-6 h-6">
                        <path fill-rule="evenodd" d="M19.916 4.626a.75.75 0 01.208 1.04l-9 13.5a.75.75 0 01-1.154.114l-6-6a.75.75 0 011.06-1.06l5.353 5.353 8.493-12.739a.75.75 0 011.04-.208z" clip-rule="evenodd" />
                    </svg>
                    <span class="whitespace-nowrap">Chỉnh sửa thành công</span>
                </div>
                <div class="flex w-full justify-end items-center mt-6 space-x-4">
                    <Button bg-color="danger" @click="cancelModifying()">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-6 h-6">
                            <path fill-rule="evenodd" d="M12 2.25c-5.385 0-9.75 4.365-9.75 9.75s4.365 9.75 9.75 9.75 9.75-4.365 9.75-9.75S17.385 2.25 12 2.25zm-1.72 6.97a.75.75 0 10-1.06 1.06L10.94 12l-1.72 1.72a.75.75 0 101.06 1.06L12 13.06l1.72 1.72a.75.75 0 101.06-1.06L13.06 12l1.72-1.72a.75.75 0 10-1.06-1.06L12 10.94l-1.72-1.72z" clip-rule="evenodd" />
                        </svg>
                        Hủy
                    </Button>
                    <Button bg-color="success" @click="sendModify()">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-6 h-6">
                            <path fill-rule="evenodd" d="M2.25 12c0-5.385 4.365-9.75 9.75-9.75s9.75 4.365 9.75 9.75-4.365 9.75-9.75 9.75S2.25 17.385 2.25 12zm13.36-1.814a.75.75 0 10-1.22-.872l-3.236 4.53L9.53 12.22a.75.75 0 00-1.06 1.06l2.25 2.25a.75.75 0 001.14-.094l3.75-5.25z" clip-rule="evenodd" />
                        </svg>
                        Chấp nhận
                    </Button>
                </div>
            </div>
        </div>
    </div>
</template>