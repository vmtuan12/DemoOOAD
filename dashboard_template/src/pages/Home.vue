<script setup>
import { ref } from 'vue';
import Modal from '../components/UI/Modal.vue';
import ModalCard from '../components/UI/ModalCard.vue';
import Button from '../components/UI/Button.vue'
import StatisticCard from '../components/UI/StatisticCard.vue';
import Table from '../components/UI/Table.vue'
import PersonalCard from '../components/UI/PersonalCard.vue';

const condition = ref(false);

const header = ref([
    {
        content: 2022,
        colWidth: 'min-w-[10rem]',
        align: 'text-center',
        key: '2022'
    },
    {
        content: 2023,
        colWidth: 'min-w-[10rem]',
        align: 'text-center',
        key: '2023'
    },
    {
        content: 2024,
        colWidth: 'min-w-[10rem]',
        align: 'text-center',
        key: '2024'
    },
]);

const body = ref([
    {
        '2022': 'Lorem ipsum',
        '2023': 'Lorem ipsum',
        '2024': 'Lorem ipsum',
    },
    {
        '2022': 'Lorem ipsum',
        '2023': 'Lorem ipsum',
        '2024': 'Lorem ipsum',
    },
    {
        '2022': 'Lorem ipsum',
        '2023': 'Lorem ipsum',
        '2024': 'Lorem ipsum',
    },
    {
        '2022': 'Lorem ipsum',
        '2023': 'Lorem ipsum',
        '2024': 'Lorem ipsum',
    },
    {
        '2022': 'Lorem ipsum',
        '2023': 'Lorem ipsum',
        '2024': 'Lorem ipsum',
    },
    {
        '2022': 'Lorem ipsum',
        '2023': 'Lorem ipsum',
        '2024': 'Lorem ipsum',
    },
    {
        '2022': 'Lorem ipsum',
        '2023': 'Lorem ipsum',
        '2024': 'Lorem ipsum',
    },
    {
        '2022': 'Lorem ipsum',
        '2023': 'Lorem ipsum',
        '2024': 'Lorem ipsum',
    },
    {
        '2022': 'Lorem ipsum',
        '2023': 'Lorem ipsum',
        '2024': 'Lorem ipsum',
    },
]);

const users = ref([
    {
        name: 'Minh Tuan',
        region: 'Ha Noi'
    },
    {
        name: 'Ha Phuong',
        region: 'Da Nang'
    },
    {
        name: 'Minh Phuong',
        region: 'Thanh Hoa'
    },
    {
        name: 'Phuong',
        region: 'Ba Vi'
    },
    {
        name: 'Tran Phuong',
        region: 'Hue'
    },
    {
        name: 'Minh Phuong',
        region: 'Ha Noi'
    },
    {
        name: 'Tuan Phuong',
        region: 'Lao cai'
    },
    {
        name: 'Phuong Vu',
        region: 'Yen Bai'
    },
    {
        name: 'Tran Tuan',
        region: 'Nghe An'
    },
]);

</script>

<template>
    <div>
        <div class="w-full mb-4 grid grid-cols-1 md:grid-cols-2 xl:grid-cols-4 grid-rows-[repeat(x,max-content),1fr] gap-4">
            <StatisticCard 
                statistic="1000" 
                category="comments"
                class="rounded-xl shadow-md"
            >
                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.75" stroke="currentColor" class="w-7 h-7 text-[#52a1f5]">
                    <path stroke-linecap="round" stroke-linejoin="round" d="M7.5 8.25h9m-9 3H12m-9.75 1.51c0 1.6 1.123 2.994 2.707 3.227 1.129.166 2.27.293 3.423.379.35.026.67.21.865.501L12 21l2.755-4.133a1.14 1.14 0 01.865-.501 48.172 48.172 0 003.423-.379c1.584-.233 2.707-1.626 2.707-3.228V6.741c0-1.602-1.123-2.995-2.707-3.228A48.394 48.394 0 0012 3c-2.392 0-4.744.175-7.043.513C3.373 3.746 2.25 5.14 2.25 6.741v6.018z" />
                </svg>
            </StatisticCard>
            <StatisticCard 
                statistic="$123.45" 
                category="income"
                color="success"
                class="rounded-xl shadow-md"
            >
            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.75" stroke="currentColor" class="w-7 h-7 text-[#39c0c8]">
                <path stroke-linecap="round" stroke-linejoin="round" d="M12 6v12m-3-2.818l.879.659c1.171.879 3.07.879 4.242 0 1.172-.879 1.172-2.303 0-3.182C13.536 12.219 12.768 12 12 12c-.725 0-1.45-.22-2.003-.659-1.106-.879-1.106-2.303 0-3.182s2.9-.879 4.006 0l.415.33M21 12a9 9 0 11-18 0 9 9 0 0118 0z" />
            </svg>
            </StatisticCard>
            <StatisticCard 
                statistic="800" 
                category="new users"
                color="orange"
                class="rounded-xl shadow-md"
            >
                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.75" stroke="currentColor" class="w-7 h-7 text-[#f96300]">
                    <path stroke-linecap="round" stroke-linejoin="round" d="M18 18.72a9.094 9.094 0 003.741-.479 3 3 0 00-4.682-2.72m.94 3.198l.001.031c0 .225-.012.447-.037.666A11.944 11.944 0 0112 21c-2.17 0-4.207-.576-5.963-1.584A6.062 6.062 0 016 18.719m12 0a5.971 5.971 0 00-.941-3.197m0 0A5.995 5.995 0 0012 12.75a5.995 5.995 0 00-5.058 2.772m0 0a3 3 0 00-4.681 2.72 8.986 8.986 0 003.74.477m.94-3.197a5.971 5.971 0 00-.94 3.197M15 6.75a3 3 0 11-6 0 3 3 0 016 0zm6 3a2.25 2.25 0 11-4.5 0 2.25 2.25 0 014.5 0zm-13.5 0a2.25 2.25 0 11-4.5 0 2.25 2.25 0 014.5 0z" />
                </svg>
            </StatisticCard>
            <StatisticCard 
                statistic="50" 
                category="dishes"
                color="neon"
                class="rounded-xl shadow-md"
            >
            <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-tabler icon-tabler-meat w-7 h-7 text-[#6c47ff]" viewBox="0 0 24 24" stroke-width="1.75" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round" >
                <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                <path d="M13.62 8.382l1.966 -1.967a2 2 0 1 1 3.414 -1.415a2 2 0 1 1 -1.413 3.414l-1.82 1.821"></path>
                <path d="M5.904 18.596c2.733 2.734 5.9 4 7.07 2.829c1.172 -1.172 -.094 -4.338 -2.828 -7.071c-2.733 -2.734 -5.9 -4 -7.07 -2.829c-1.172 1.172 .094 4.338 2.828 7.071z"></path>
                <path d="M7.5 16l1 1"></path>
                <path d="M12.975 21.425c3.905 -3.906 4.855 -9.288 2.121 -12.021c-2.733 -2.734 -8.115 -1.784 -12.02 2.121"></path>
            </svg>
            </StatisticCard>
        </div>
        <div class="bg-white rounded-xl shadow flex flex-col space-y-4 p-4 mb-4">
            <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
                Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                Excepteur sint occaecat cupidatat non proident,
                sunt in culpa qui officia deserunt mollit anim id est laborum.
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
                Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                Excepteur sint occaecat cupidatat non proident,
                sunt in culpa qui officia deserunt mollit anim id est laborum.
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
                Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                Excepteur sint occaecat cupidatat non proident,
                sunt in culpa qui officia deserunt mollit anim id est laborum.
            </p>
            <Button bg-color="success" @click="condition = true" class="w-fit">Show modal</Button>
        </div>
        <div class="w-full flex max-lg:flex-col lg:items-start max-lg:space-y-4 lg:space-x-2">
            <div class="w-2/3 max-lg:w-full bg-white rounded-xl p-4 shadow">
                <Table
                    :header="header"
                    :data="body"
                    max-height="max-h-[20rem]"
                    name="Statistic over 3 years"
                >
                    <template #action-header>
                        Action
                    </template>
                    <template #action>
                        <Button border-radius="full">Active</Button>
                    </template>
                </Table>
            </div>
            <div class="w-1/3 max-lg:w-full bg-white rounded-xl shadow px-4 pb-4 space-y-2">
                <p class="font-semibold text-xl py-2 bg-white">
                    Recent access
                </p>
                <div class="w-full max-h-[20.5rem] overflow-y-scroll space-y-2">
                    <PersonalCard 
                        v-for="item in users"
                        :key="item"
                        :name="item.name"
                        :region="item.region"
                    />
                </div>
            </div>
        </div>
        <Modal :condition="condition" @exit-modal="condition = false">
            <ModalCard @exit-modal="condition = false" class="max-w-4xl rounded-lg shadow">
                <template #title>
                    <p class="text-center text-3xl font-semibold">Lorem ipsum</p>
                </template>
                <template #body>
                    <div class="max-h-96 overflow-y-scroll">
                        <p>
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
                            sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
                            Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
                            Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                            Excepteur sint occaecat cupidatat non proident,
                            sunt in culpa qui officia deserunt mollit anim id est laborum.
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
                            sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
                            Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
                            Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                            Excepteur sint occaecat cupidatat non proident,
                            sunt in culpa qui officia deserunt mollit anim id est laborum.
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
                            sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
                            Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
                            Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                            Excepteur sint occaecat cupidatat non proident,
                            sunt in culpa qui officia deserunt mollit anim id est laborum.
                        </p>
                        <p>
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
                            sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
                            Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
                            Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                            Excepteur sint occaecat cupidatat non proident,
                            sunt in culpa qui officia deserunt mollit anim id est laborum.
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
                            sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
                            Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
                            Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                            Excepteur sint occaecat cupidatat non proident,
                            sunt in culpa qui officia deserunt mollit anim id est laborum.
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
                            sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
                            Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
                            Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                            Excepteur sint occaecat cupidatat non proident,
                            sunt in culpa qui officia deserunt mollit anim id est laborum.
                        </p>
                        <p>
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
                            sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
                            Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
                            Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                            Excepteur sint occaecat cupidatat non proident,
                            sunt in culpa qui officia deserunt mollit anim id est laborum.
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
                            sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
                            Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
                            Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                            Excepteur sint occaecat cupidatat non proident,
                            sunt in culpa qui officia deserunt mollit anim id est laborum.
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
                            sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
                            Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
                            Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                            Excepteur sint occaecat cupidatat non proident,
                            sunt in culpa qui officia deserunt mollit anim id est laborum.
                        </p>
                    </div>
                </template>
            </ModalCard>
        </Modal>
    </div>
</template>

<style scoped>
      
</style>