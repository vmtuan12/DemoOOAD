<script setup>
import { onMounted, ref } from 'vue';
import Input from '../Input.vue';

const props = defineProps(['list', 'data']);
const emits = defineEmits(['bindType']);

const openPopup = ref(false);

const data = ref(null);

const bindData = (val) => {
    data.value = val;
    openPopup.value = false;
    emits('bindType', val);
};

onMounted(() => {
    data.value = props.data;
});
</script>

<template>
    <div class="w-full relative z-40 mb-4">
        <Input onkeydown="return false" v-model="data" @focus="openPopup = true" border-color="blue" placeholder="Chọn...">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-6 h-6 text-[#3d96f5]">
                <path fill-rule="evenodd" d="M4.848 2.771A49.144 49.144 0 0112 2.25c2.43 0 4.817.178 7.152.52 1.978.292 3.348 2.024 3.348 3.97v6.02c0 1.946-1.37 3.678-3.348 3.97a48.901 48.901 0 01-3.476.383.39.39 0 00-.297.17l-2.755 4.133a.75.75 0 01-1.248 0l-2.755-4.133a.39.39 0 00-.297-.17 48.9 48.9 0 01-3.476-.384c-1.978-.29-3.348-2.024-3.348-3.97V6.741c0-1.946 1.37-3.68 3.348-3.97zM6.75 8.25a.75.75 0 01.75-.75h9a.75.75 0 010 1.5h-9a.75.75 0 01-.75-.75zm.75 2.25a.75.75 0 000 1.5H12a.75.75 0 000-1.5H7.5z" clip-rule="evenodd" />
            </svg>
        </Input>
        <div v-if="openPopup" class="absolute z-50 bg-white w-full max-h-24 overflow-y-scroll rounded-[4px] shadow-md mt-1 shadow-[#3d96f5]/40">
            <div class="flex items-center my-2 px-1 mx-2 py-1.5 rounded-sm transition-colors hover:bg-[#f34971]/20" @click="bindData(null)">
                <span class="ml-4 font-semibold text-[#f34971]">Bỏ chọn</span>
            </div>
            <div v-for="item in list" :key="item" class="flex items-center my-2 px-1 mx-2 py-1.5 rounded-sm transition-colors hover:bg-[#3d96f5]/20" @click="bindData(item)">
                <span class="ml-4 font-semibold">{{ item }}</span>
            </div>
        </div>
    </div>
</template>