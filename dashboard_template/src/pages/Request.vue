<script setup>
import { ref } from 'vue';
import Modal from '../components/UI/Modal.vue';
import ModalCard from '../components/UI/ModalCard.vue';
import HorizontalCard from '../components/UI/Request/HorizontalCard.vue';
import Button from '../components/UI/Button.vue';
import RequestPicker from '../components/UI/Request/RequestPicker.vue';

const detailCondition = ref(false);
const addCondition = ref(false);

const data = ref([
    {
        id: 1,
        type: 'CONG_VIEC',
        sendTime: '28/12/2003 18:00:00',
        title: 'Yêu cầu 1',
        receiver: 'Trần Hà Phương',
        status: 'Phê duyệt'
    },
    {
        id: 2,
        type: 'CA_NHAN',
        sendTime: '28/12/2003 18:00:00',
        title: 'Yêu cầu 1',
        receiver: 'Trần Hà Phương',
        status: 'Phê duyệt'
    },
    {
        id: 3,
        type: 'CSHS',
        sendTime: '28/12/2003 18:00:00',
        title: 'Yêu cầu 1',
        receiver: 'Trần Hà Phương',
        status: 'Phê duyệt'
    },
    {
        id: 4,
        type: 'FIXED_SAL',
        sendTime: '28/12/2003 18:00:00',
        title: 'Yêu cầu 1',
        receiver: 'Trần Hà Phương',
        status: 'Phê duyệt'
    },
    {
        id: 5,
        type: 'MONTH_SAL',
        sendTime: '28/12/2003 18:00:00',
        title: 'Yêu cầu 1',
        receiver: 'Trần Hà Phương',
        status: 'Phê duyệt'
    },
    {
        id: 6,
        type: 'RE_EVAL',
        sendTime: '28/12/2003 18:00:00',
        title: 'Yêu cầu 1',
        receiver: 'Trần Hà Phương',
        status: 'Phê duyệt'
    },
    {
        id: 7,
        type: 'CONG_VIEC',
        sendTime: '28/12/2003 18:00:00',
        title: 'Yêu cầu 1',
        receiver: 'Trần Hà Phương',
        status: 'Phê duyệt'
    },
]);

const request = ref({
    title: null,
    content: null,
    note: null
});

const viewSentRequest = ref(true);
const viewRequestType = ref(null);

const pickRequestType = (val) => {
    viewRequestType.value = val;
}

const sendRequest = () => {

};

</script>

<template>
    <div class="w-full py-6">
        <div class="w-full mb-4 flex justify-between">
            <p class="font-semibold text-2xl">Danh sách yêu cầu</p>
            <Button @click="addCondition = true">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-6 h-6">
                    <path fill-rule="evenodd" d="M12 2.25c-5.385 0-9.75 4.365-9.75 9.75s4.365 9.75 9.75 9.75 9.75-4.365 9.75-9.75S17.385 2.25 12 2.25zM12.75 9a.75.75 0 00-1.5 0v2.25H9a.75.75 0 000 1.5h2.25V15a.75.75 0 001.5 0v-2.25H15a.75.75 0 000-1.5h-2.25V9z" clip-rule="evenodd" />
                </svg>
                Tạo yêu cầu
            </Button>
        </div>
        <div class="flex justify-between items-center">
            <div class="flex">
                <div @click="viewSentRequest = true" class="flex items-center gap-x-1 px-6 py-3 rounded-sm cursor-pointer transition-colors" :class="viewSentRequest ? 'bg-[#52a1f5] text-white' : 'hover:bg-[#52a1f5]/30'">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                        <path stroke-linecap="round" stroke-linejoin="round" d="M19.5 14.25v-2.625a3.375 3.375 0 00-3.375-3.375h-1.5A1.125 1.125 0 0113.5 7.125v-1.5a3.375 3.375 0 00-3.375-3.375H8.25m6.75 12l-3-3m0 0l-3 3m3-3v6m-1.5-15H5.625c-.621 0-1.125.504-1.125 1.125v17.25c0 .621.504 1.125 1.125 1.125h12.75c.621 0 1.125-.504 1.125-1.125V11.25a9 9 0 00-9-9z" />
                    </svg>
                    <span>Yêu cầu đã gửi</span>
                </div>
                <div @click="viewSentRequest = false" class="flex items-center gap-x-1 px-6 py-3 rounded-sm cursor-pointer transition-colors" :class="!viewSentRequest ? 'bg-[#52a1f5] text-white' : 'hover:bg-[#52a1f5]/30'">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                        <path stroke-linecap="round" stroke-linejoin="round" d="M10.125 2.25h-4.5c-.621 0-1.125.504-1.125 1.125v17.25c0 .621.504 1.125 1.125 1.125h12.75c.621 0 1.125-.504 1.125-1.125v-9M10.125 2.25h.375a9 9 0 019 9v.375M10.125 2.25A3.375 3.375 0 0113.5 5.625v1.5c0 .621.504 1.125 1.125 1.125h1.5a3.375 3.375 0 013.375 3.375M9 15l2.25 2.25L15 12" />
                    </svg>
                    <span>Yêu cầu đã xử lý</span>
                </div>
            </div>
            <div>
                <RequestPicker @emit-bind-type="pickRequestType" />
            </div>
        </div>
        <div class="px-4 py-2 items-center grid grid-cols-5 grid-rows-[repeat(x,max-content),1fr] font-bold text-sm">
            <span class="text-center">Loại yêu cầu</span>
            <span>Tiêu đề</span>
            <span class="text-center">Thời gian gửi</span>
            <span class="text-center">Người xử lý</span>
            <span class="text-center">Trạng thái</span>
        </div>
        <HorizontalCard v-for="item in data" :key="item.id" :request="item" @open-detail="detailCondition = true">
            <svg v-if="item.type == 'CONG_VIEC'" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-6 h-6">
                <path fill-rule="evenodd" d="M7.5 5.25a3 3 0 013-3h3a3 3 0 013 3v.205c.933.085 1.857.197 2.774.334 1.454.218 2.476 1.483 2.476 2.917v3.033c0 1.211-.734 2.352-1.936 2.752A24.726 24.726 0 0112 15.75c-2.73 0-5.357-.442-7.814-1.259-1.202-.4-1.936-1.541-1.936-2.752V8.706c0-1.434 1.022-2.7 2.476-2.917A48.814 48.814 0 017.5 5.455V5.25zm7.5 0v.09a49.488 49.488 0 00-6 0v-.09a1.5 1.5 0 011.5-1.5h3a1.5 1.5 0 011.5 1.5zm-3 8.25a.75.75 0 100-1.5.75.75 0 000 1.5z" clip-rule="evenodd" />
                <path d="M3 18.4v-2.796a4.3 4.3 0 00.713.31A26.226 26.226 0 0012 17.25c2.892 0 5.68-.468 8.287-1.335.252-.084.49-.189.713-.311V18.4c0 1.452-1.047 2.728-2.523 2.923-2.12.282-4.282.427-6.477.427a49.19 49.19 0 01-6.477-.427C4.047 21.128 3 19.852 3 18.4z" />
            </svg>
            <svg v-else-if="item.type == 'CA_NHAN'" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-6 h-6">
                <path fill-rule="evenodd" d="M7.5 6a4.5 4.5 0 119 0 4.5 4.5 0 01-9 0zM3.751 20.105a8.25 8.25 0 0116.498 0 .75.75 0 01-.437.695A18.683 18.683 0 0112 22.5c-2.786 0-5.433-.608-7.812-1.7a.75.75 0 01-.437-.695z" clip-rule="evenodd" />
            </svg>
            <svg v-else-if="item.type == 'CSHS'" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-6 h-6">
                <path fill-rule="evenodd" d="M4.5 3.75a3 3 0 00-3 3v10.5a3 3 0 003 3h15a3 3 0 003-3V6.75a3 3 0 00-3-3h-15zm4.125 3a2.25 2.25 0 100 4.5 2.25 2.25 0 000-4.5zm-3.873 8.703a4.126 4.126 0 017.746 0 .75.75 0 01-.351.92 7.47 7.47 0 01-3.522.877 7.47 7.47 0 01-3.522-.877.75.75 0 01-.351-.92zM15 8.25a.75.75 0 000 1.5h3.75a.75.75 0 000-1.5H15zM14.25 12a.75.75 0 01.75-.75h3.75a.75.75 0 010 1.5H15a.75.75 0 01-.75-.75zm.75 2.25a.75.75 0 000 1.5h3.75a.75.75 0 000-1.5H15z" clip-rule="evenodd" />
            </svg>
            <svg v-else-if="item.type == 'FIXED_SAL'" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-6 h-6">
                <path d="M4.5 3.75a3 3 0 00-3 3v.75h21v-.75a3 3 0 00-3-3h-15z" />
                <path fill-rule="evenodd" d="M22.5 9.75h-21v7.5a3 3 0 003 3h15a3 3 0 003-3v-7.5zm-18 3.75a.75.75 0 01.75-.75h6a.75.75 0 010 1.5h-6a.75.75 0 01-.75-.75zm.75 2.25a.75.75 0 000 1.5h3a.75.75 0 000-1.5h-3z" clip-rule="evenodd" />
            </svg>
            <svg v-else-if="item.type == 'MONTH_SAL'" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-6 h-6">
                <path d="M12 7.5a2.25 2.25 0 100 4.5 2.25 2.25 0 000-4.5z" />
                <path fill-rule="evenodd" d="M1.5 4.875C1.5 3.839 2.34 3 3.375 3h17.25c1.035 0 1.875.84 1.875 1.875v9.75c0 1.036-.84 1.875-1.875 1.875H3.375A1.875 1.875 0 011.5 14.625v-9.75zM8.25 9.75a3.75 3.75 0 117.5 0 3.75 3.75 0 01-7.5 0zM18.75 9a.75.75 0 00-.75.75v.008c0 .414.336.75.75.75h.008a.75.75 0 00.75-.75V9.75a.75.75 0 00-.75-.75h-.008zM4.5 9.75A.75.75 0 015.25 9h.008a.75.75 0 01.75.75v.008a.75.75 0 01-.75.75H5.25a.75.75 0 01-.75-.75V9.75z" clip-rule="evenodd" />
                <path d="M2.25 18a.75.75 0 000 1.5c5.4 0 10.63.722 15.6 2.075 1.19.324 2.4-.558 2.4-1.82V18.75a.75.75 0 00-.75-.75H2.25z" />
            </svg>
            <svg v-else xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-6 h-6">
                <path fill-rule="evenodd" d="M4.804 21.644A6.707 6.707 0 006 21.75a6.721 6.721 0 003.583-1.029c.774.182 1.584.279 2.417.279 5.322 0 9.75-3.97 9.75-9 0-5.03-4.428-9-9.75-9s-9.75 3.97-9.75 9c0 2.409 1.025 4.587 2.674 6.192.232.226.277.428.254.543a3.73 3.73 0 01-.814 1.686.75.75 0 00.44 1.223zM8.25 10.875a1.125 1.125 0 100 2.25 1.125 1.125 0 000-2.25zM10.875 12a1.125 1.125 0 112.25 0 1.125 1.125 0 01-2.25 0zm4.875-1.125a1.125 1.125 0 100 2.25 1.125 1.125 0 000-2.25z" clip-rule="evenodd" />
            </svg>
        </HorizontalCard>

        <Modal :condition="detailCondition" @exit-modal="detailCondition = false">
            <ModalCard @exit-modal="detailCondition = false" class="max-w-4xl rounded-lg shadow">
                <template #title>
                    <p class="text-center text-3xl font-semibold">Yêu cầu tăng lương</p>
                </template>
                <template #body>
                    <p class="text-right px-4 text-[#39c0c8] font-bold">Phê duyệt</p>
                    <div class="max-h-96 overflow-y-scroll pt-4 items-center grid grid-cols-3 grid-rows-[repeat(x,max-content),1fr] gap-x-32 gap-y-10 px-4">
                        <div>
                            <p class="text-sm font-bold text-slate-800">Thời gian gửi</p>
                            <p>28/12/2003 18:00:00</p>
                        </div>
                        <div>
                            <p class="text-sm font-bold text-slate-800">Thời gian nhận</p>
                            <p>28/12/2003 18:00:00</p>
                        </div>
                        <div>
                            <p class="text-sm font-bold text-slate-800 text-right">Người xử lý</p>
                            <p class="text-right">Trần Hà Phương</p>
                        </div>
                    </div>
                    <div class="mt-4 px-4">
                        <p class="text-sm font-bold text-slate-800">Nội dung</p>
                        <p class="text-justify">
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur
                        </p>
                        <p class="text-sm font-bold text-slate-800">Ghi chú</p>
                        <p class="text-justify">
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                        </p>
                    </div>
                </template>
            </ModalCard>
        </Modal>

        <Modal :condition="addCondition" @exit-modal="addCondition = false">
            <ModalCard @exit-modal="addCondition = false" class="max-w-4xl rounded-lg shadow">
                <template #title>
                    <p class="text-center text-3xl font-semibold">Tạo mới yêu cầu</p>
                </template>
                <template #body>
                    <div class="py-4 px-6">
                        <RequestPicker></RequestPicker>
                        <span class="text-sm font-bold text-slate-800 mt-4 mb-1">Tiêu đề</span>
                        <textarea v-model="request.title" class="w-full border-[#3d96f5] border-2 rounded-md focus:outline-none p-2"></textarea>
                        <span class="text-sm font-bold text-slate-800 mt-4 mb-1">Nội dung</span>
                        <textarea v-model="request.content" class="w-full border-[#3d96f5] border-2 rounded-md focus:outline-none p-2"></textarea>
                        <span class="text-sm font-bold text-slate-800 mt-4 mb-1">Ghi chú</span>
                        <textarea v-model="request.note" class="w-full border-[#3d96f5] border-2 rounded-md focus:outline-none p-2"></textarea>
 
                        <div class="flex justify-center">
                            <Button bg-color="success" class="mt-4" @click="sendRequest()">
                                Gửi yêu cầu
                            </Button>
                        </div>
                    </div>
                </template>
            </ModalCard>
        </Modal>
    </div>
</template>