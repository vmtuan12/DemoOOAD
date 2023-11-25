<script setup>
import { onMounted, ref } from 'vue';
import Notification from './Notification.vue';

const popupShowed = ref(false);

const noti = [
    {
        id: 1,
        status: false,
        content: 'dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai',
        sentTime: '2023-11-20 22:14:54'
    },
    {
        id: 2,
        status: false,
        content: 'dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai',
        sentTime: '2023-11-20 22:14:54'
    },
    {
        id: 3,
        status: false,
        content: 'dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai',
        sentTime: '2023-11-20 22:14:54'
    },
    {
        id: 4,
        status: false,
        content: 'dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai',
        sentTime: '2023-11-20 22:14:54'
    },
    {
        id: 5,
        status: false,
        content: 'dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai',
        sentTime: '2023-11-20 22:14:54'
    },
    {
        id: 6,
        status: false,
        content: 'dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai',
        sentTime: '2023-11-20 22:14:54'
    },
    {
        id: 7,
        status: false,
        content: 'dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai dep trai',
        sentTime: '2023-11-20 22:14:54'
    },
];

const notificationData = ref(null);

const fetchNotifications = async () => {
    const res = await fetch("http://localhost:8080/notification/all", {
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
    notificationData.value = dataFetched;
};

onMounted(() => {
    fetchNotifications();
});

</script>

<template>
    <div class="relative flex flex-col items-end z-[100]">
        <svg @click="popupShowed = !popupShowed" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-8 h-8 cursor-pointer">
            <path fill-rule="evenodd" d="M5.25 9a6.75 6.75 0 0113.5 0v.75c0 2.123.8 4.057 2.118 5.52a.75.75 0 01-.297 1.206c-1.544.57-3.16.99-4.831 1.243a3.75 3.75 0 11-7.48 0 24.585 24.585 0 01-4.831-1.244.75.75 0 01-.298-1.205A8.217 8.217 0 005.25 9.75V9zm4.502 8.9a2.25 2.25 0 104.496 0 25.057 25.057 0 01-4.496 0z" clip-rule="evenodd" />
        </svg>
        <Transition name="bounce">
            <div v-if="popupShowed" class="bg-white flex flex-col space-y-3 text-[#1d1d1d] p-3 rounded-[4px] absolute z-10 mt-12 mr-1 shadow-md w-[30rem] max-h-52 overflow-y-scroll">
                <p class="px-4 font-bold text-[#f96300] text-lg">Thông báo</p>
                <Notification v-for="item in notificationData" :key="item.id" :notification="item"/>
            </div>
        </Transition>
    </div>
</template>

<style scoped>
.bounce-enter-active {
    animation: bounce-in 0.5s;
    transform-origin: top right;
}

.bounce-leave-active {
    animation: bounce-in 0.5s reverse;
    transform-origin: top right;
}

@keyframes bounce-in {
    0% {
        transform: scale(0);
    }
    50% {
        transform: scale(1.15);
    }
    100% {
        transform: scale(1);
    }
}
</style>