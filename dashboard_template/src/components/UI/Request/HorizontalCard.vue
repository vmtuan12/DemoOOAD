<script setup>
const props = defineProps(['request']);
const emits = defineEmits(['openDetail']);
</script>

<template>
    <div class="bg-white rounded-lg shadow p-4 items-center grid grid-cols-5 grid-rows-[repeat(x,max-content),1fr] mb-1">
        <svg @click="$emit('openDetail')" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-6 h-6 absolute text-slate-400 cursor-pointer transition-colors hover:text-slate-500">
            <path fill-rule="evenodd" d="M2.25 12c0-5.385 4.365-9.75 9.75-9.75s9.75 4.365 9.75 9.75-4.365 9.75-9.75 9.75S2.25 17.385 2.25 12zm8.706-1.442c1.146-.573 2.437.463 2.126 1.706l-.709 2.836.042-.02a.75.75 0 01.67 1.34l-.04.022c-1.147.573-2.438-.463-2.127-1.706l.71-2.836-.042.02a.75.75 0 11-.671-1.34l.041-.022zM12 9a.75.75 0 100-1.5.75.75 0 000 1.5z" clip-rule="evenodd" />
        </svg>
        <div class="w-full flex justify-center text-[#52a1f5]">
            <slot></slot>
        </div>
        <span class="text-justify">{{ request.title }}</span>
        <span class="text-center">{{ request.sendTime }}</span>
        <span class="text-center">{{ request.receiver }}</span>
        <span class="text-center">{{ request.status }}</span>
    </div>
</template>