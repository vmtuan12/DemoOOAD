<script setup>
import { onMounted, ref } from 'vue';
import IconInput from '../IconInput.vue';

const props = defineProps(['role']);
const emits = defineEmits(['emitBindType']);

const openPopup = ref(false);

const type = ref(null);

const roleMapping = {
    'HR': 'Nhân sự',
    'ACCOUNTANT': 'Kế toán',
    'ADMINISTRATIVE': 'Chuyên viên hành chính',
    'EMPLOYEE': 'Nhân viên',
    'PRESIDENT': 'Giám đốc'
}

const bindType = (val) => {
    type.value = roleMapping[val];
    openPopup.value = false;
    emits('emitBindType', val);
};

onMounted(() => {
    if (props.role == undefined || props.role == null) {
        type.value = roleMapping['EMPLOYEE'];
    } else {
        type.value = roleMapping[props.role];
    }
});

</script>

<template>
    <div class="w-full relative z-50 mb-4">
        <IconInput v-model="type" @focus="openPopup = true" border-color="blue" placeholder="Chọn quyền...">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-6 h-6 text-[#3d96f5]">
                <path d="M11.25 4.533A9.707 9.707 0 006 3a9.735 9.735 0 00-3.25.555.75.75 0 00-.5.707v14.25a.75.75 0 001 .707A8.237 8.237 0 016 18.75c1.995 0 3.823.707 5.25 1.886V4.533zM12.75 20.636A8.214 8.214 0 0118 18.75c.966 0 1.89.166 2.75.47a.75.75 0 001-.708V4.262a.75.75 0 00-.5-.707A9.735 9.735 0 0018 3a9.707 9.707 0 00-5.25 1.533v16.103z" />
            </svg>
        </IconInput>
        <div v-if="openPopup" class="absolute z-50 bg-white w-full max-h-40 overflow-y-scroll rounded-[4px] shadow-md mt-1 shadow-[#3d96f5]/40">
            <div class="flex items-center my-2 px-1 mx-2 py-1.5 rounded-sm transition-colors hover:bg-[#3d96f5]/20" @click="bindType('EMPLOYEE')">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-6 h-6 text-[#3d96f5]">
                    <path fill-rule="evenodd" d="M7.5 5.25a3 3 0 013-3h3a3 3 0 013 3v.205c.933.085 1.857.197 2.774.334 1.454.218 2.476 1.483 2.476 2.917v3.033c0 1.211-.734 2.352-1.936 2.752A24.726 24.726 0 0112 15.75c-2.73 0-5.357-.442-7.814-1.259-1.202-.4-1.936-1.541-1.936-2.752V8.706c0-1.434 1.022-2.7 2.476-2.917A48.814 48.814 0 017.5 5.455V5.25zm7.5 0v.09a49.488 49.488 0 00-6 0v-.09a1.5 1.5 0 011.5-1.5h3a1.5 1.5 0 011.5 1.5zm-3 8.25a.75.75 0 100-1.5.75.75 0 000 1.5z" clip-rule="evenodd" />
                    <path d="M3 18.4v-2.796a4.3 4.3 0 00.713.31A26.226 26.226 0 0012 17.25c2.892 0 5.68-.468 8.287-1.335.252-.084.49-.189.713-.311V18.4c0 1.452-1.047 2.728-2.523 2.923-2.12.282-4.282.427-6.477.427a49.19 49.19 0 01-6.477-.427C4.047 21.128 3 19.852 3 18.4z" />
                </svg>
                <span class="ml-4 font-semibold">Nhân viên</span>
            </div>
            <div class="flex items-center my-2 px-1 mx-2 py-1.5 rounded-sm transition-colors hover:bg-[#3d96f5]/20" @click="bindType('ADMINISTRATIVE')">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-6 h-6 text-[#3d96f5]">
                    <path fill-rule="evenodd" d="M7.5 6a4.5 4.5 0 119 0 4.5 4.5 0 01-9 0zM3.751 20.105a8.25 8.25 0 0116.498 0 .75.75 0 01-.437.695A18.683 18.683 0 0112 22.5c-2.786 0-5.433-.608-7.812-1.7a.75.75 0 01-.437-.695z" clip-rule="evenodd" />
                </svg>
                <span class="ml-4 font-semibold">Chuyên viên hành chính</span>
            </div>
            <div class="flex items-center my-2 px-1 mx-2 py-1.5 rounded-sm transition-colors hover:bg-[#3d96f5]/20" @click="bindType('ACCOUNTANT')">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-6 h-6 text-[#3d96f5]">
                    <path fill-rule="evenodd" d="M4.5 3.75a3 3 0 00-3 3v10.5a3 3 0 003 3h15a3 3 0 003-3V6.75a3 3 0 00-3-3h-15zm4.125 3a2.25 2.25 0 100 4.5 2.25 2.25 0 000-4.5zm-3.873 8.703a4.126 4.126 0 017.746 0 .75.75 0 01-.351.92 7.47 7.47 0 01-3.522.877 7.47 7.47 0 01-3.522-.877.75.75 0 01-.351-.92zM15 8.25a.75.75 0 000 1.5h3.75a.75.75 0 000-1.5H15zM14.25 12a.75.75 0 01.75-.75h3.75a.75.75 0 010 1.5H15a.75.75 0 01-.75-.75zm.75 2.25a.75.75 0 000 1.5h3.75a.75.75 0 000-1.5H15z" clip-rule="evenodd" />
                </svg>
                <span class="ml-4 font-semibold">Kế toán</span>
            </div>
            <div class="flex items-center my-2 px-1 mx-2 py-1.5 rounded-sm transition-colors hover:bg-[#3d96f5]/20" @click="bindType('HR')">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-6 h-6 text-[#3d96f5]">
                    <path d="M4.5 3.75a3 3 0 00-3 3v.75h21v-.75a3 3 0 00-3-3h-15z" />
                    <path fill-rule="evenodd" d="M22.5 9.75h-21v7.5a3 3 0 003 3h15a3 3 0 003-3v-7.5zm-18 3.75a.75.75 0 01.75-.75h6a.75.75 0 010 1.5h-6 text-[#3d96f5]a.75.75 0 01-.75-.75zm.75 2.25a.75.75 0 000 1.5h3a.75.75 0 000-1.5h-3z" clip-rule="evenodd" />
                </svg>
                <span class="ml-4 font-semibold">Nhân sự</span>
            </div>
        </div>
    </div>
</template>