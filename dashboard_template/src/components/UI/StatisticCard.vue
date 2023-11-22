<script setup>
import { ref } from 'vue';

const props = defineProps(['statistic', 'category', 'color']);

const colorArray = ref({
    primary: 'text-[#52a1f5]',
    success: 'text-[#39c0c8]',
    danger: 'text-[#f34971]',
    neon: 'text-[#6c47ff]',
    orange: 'text-[#f96300]',
    amber: 'text-[#f5c900]',
    coral: 'text-[#ff9382]',
});
</script>

<template>
    <div class="bg-white w-full py-7 px-8 max-md:px-6">
        <div class="w-full flex items-center mb-2 justify-between">
            <slot></slot>
            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.75" stroke="currentColor" class="w-10 h-10 rounded-full p-2 cursor-pointer transition-colors hover:bg-slate-100 active:bg-slate-200">
                <path stroke-linecap="round" stroke-linejoin="round" d="M4.5 12h15m0 0l-6.75-6.75M19.5 12l-6.75 6.75" />
            </svg>
        </div>
        <p 
            class="font-semibold text-4xl"
            :class="colorArray[color] !== undefined ? colorArray[color] : colorArray['primary']"
        >
            {{ statistic }}
        </p>
    </div>
</template>