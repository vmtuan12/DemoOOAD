<script setup>
import { ref } from 'vue';

const props = defineProps(['notification']);
const emit = defineEmits(['check']);

const isChecked = ref(props.notification.status ? true : false);

const checkNotification = async (id) => {
    const res = await fetch(`http://localhost:8080/notification/check?id=${id}`, {
        method: "PUT",
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${localStorage.getItem('token')}`
        },
    })
    if(res.error) {
        console.log(res.error);
    }
    isChecked.value = true;
};
</script>

<template>
    <div class="flex flex-col px-4 py-2">
        <div class="w-full flex justify-between">
            <div class="flex items-end mb-2 gap-x-2">
                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-7 h-7 text-[#f96300]">
                    <path stroke-linecap="round" stroke-linejoin="round" d="M14.857 17.082a23.848 23.848 0 005.454-1.31A8.967 8.967 0 0118 9.75v-.7V9A6 6 0 006 9v.75a8.967 8.967 0 01-2.312 6.022c1.733.64 3.56 1.085 5.455 1.31m5.714 0a24.255 24.255 0 01-5.714 0m5.714 0a3 3 0 11-5.714 0M3.124 7.5A8.969 8.969 0 015.292 3m13.416 0a8.969 8.969 0 012.168 4.5" />
                </svg>
            </div>
            <div>
                <svg 
                    v-if="!isChecked" @click="checkNotification(notification.id);"
                    xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" stroke-width="1.75" fill="currentColor" class="w-7 h-7 p-1 text-[#39c0c8] rounded-full cursor-pointer transition-colors ease-in-out hover:bg-[#39c0c8]/20">
                    <path fill-rule="evenodd" d="M19.916 4.626a.75.75 0 01.208 1.04l-9 13.5a.75.75 0 01-1.154.114l-6-6a.75.75 0 011.06-1.06l5.353 5.353 8.493-12.739a.75.75 0 011.04-.208z" clip-rule="evenodd" />
                </svg>
                <span v-else class="text-[#39c0c8]">Đã xem</span>
            </div>
        </div>
        <p class="font-medium text-justify">{{ notification.content }}</p>
        <p class="text-right text-[11px] font-bold mt-1">Thời gian nhận: {{ notification.sentTimeStr }}</p>
    </div>
</template>