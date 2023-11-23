<script setup>
import { ref } from 'vue';

const props = defineProps(['notiId' ,'sender', 'content']);
const emit = defineEmits(['check']);

const isChecked = ref(false);

const handleCheck = () => {
    isChecked.value = true;
};
</script>

<template>
    <div class="flex flex-col px-4 py-2">
        <div class="w-full flex justify-between">
            <div class="flex items-end mb-2 gap-x-2">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-5 h-5 text-[#f96300]">
                    <path fill-rule="evenodd" d="M7.5 6a4.5 4.5 0 119 0 4.5 4.5 0 01-9 0zM3.751 20.105a8.25 8.25 0 0116.498 0 .75.75 0 01-.437.695A18.683 18.683 0 0112 22.5c-2.786 0-5.433-.608-7.812-1.7a.75.75 0 01-.437-.695z" clip-rule="evenodd" />
                </svg>
                <span class="text-sm text-[#1d1d1d] font-bold">{{ sender }}</span>
            </div>
            <div>
                <svg 
                    v-if="!isChecked" @click="handleCheck()"
                    xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" stroke-width="1.75" fill="currentColor" class="w-7 h-7 p-1 text-[#39c0c8] rounded-full cursor-pointer transition-colors ease-in-out hover:bg-[#39c0c8]/20">
                    <path fill-rule="evenodd" d="M19.916 4.626a.75.75 0 01.208 1.04l-9 13.5a.75.75 0 01-1.154.114l-6-6a.75.75 0 011.06-1.06l5.353 5.353 8.493-12.739a.75.75 0 011.04-.208z" clip-rule="evenodd" />
                </svg>
                <span v-else class="text-[#39c0c8]">Đã xem</span>
            </div>
        </div>
        <p class="font-medium">{{ content }}</p>
    </div>
</template>