<script setup>
const props = defineProps(['acc']);
</script>

<template>
    <div class="w-full px-4 py-3 grid grid-cols-3 grid-rows-[repeat(x,max-content),1fr] gap-x-5 bg-white shadow rounded-sm mb-1">
        <span class="text-center">{{ acc.account }}</span>
        <span class="text-center">{{ acc.name }}</span>
        <div class="flex items-center justify-center space-x-4">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-7 h-7 p-1 cursor-pointer text-[#6c47ff] rounded-full transition-colors hover:bg-[#6c47ff]/20">
                <path d="M21.731 2.269a2.625 2.625 0 00-3.712 0l-1.157 1.157 3.712 3.712 1.157-1.157a2.625 2.625 0 000-3.712zM19.513 8.199l-3.712-3.712-12.15 12.15a5.25 5.25 0 00-1.32 2.214l-.8 2.685a.75.75 0 00.933.933l2.685-.8a5.25 5.25 0 002.214-1.32L19.513 8.2z" />
            </svg>
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-7 h-7 p-1 cursor-pointer text-[#f34971] rounded-full transition-colors hover:bg-[#f34971]/20">
                <path d="M10.375 2.25a4.125 4.125 0 100 8.25 4.125 4.125 0 000-8.25zM10.375 12a7.125 7.125 0 00-7.124 7.247.75.75 0 00.363.63 13.067 13.067 0 006.761 1.873c2.472 0 4.786-.684 6.76-1.873a.75.75 0 00.364-.63l.001-.12v-.002A7.125 7.125 0 0010.375 12zM16 9.75a.75.75 0 000 1.5h6a.75.75 0 000-1.5h-6z" />
            </svg>
        </div>
    </div>
</template>