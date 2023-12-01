<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import IconInput from '../components/UI/IconInput.vue';
import img from '../assets/vector_img.svg'

const router = useRouter()

const email = ref(null);
const password = ref(null);
const wrongInfo = ref(false);

const signIn = async () => {
    const res = await fetch(`http://localhost:8080/auth/sign-in`, {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username: email.value,
            password: password.value
        })
    })
    if (res.status != 200) {
        wrongInfo.value = true;
    } else {
        router.push('/')
    }
};

</script>

<template>
    <div class="w-4/5 max-[480px]:w-full relative flex items-end max-md:flex-col max-md:justify-end shadow-lg md:h-[30rem] md:max-h-[30rem] max-md:h-fit md:min-w-[650px] md:max-w-4xl rounded-3xl overflow-hidden bg-gradient-to-r from-[#52a1f5] to-[#39c0c8]">
        <div class="md:hidden py-4 w-full bg-gradient-to-r from-[#52a1f5] to-[#39c0c8] flex items-center justify-center text-2xl font-bold text-white">
            Xin chào
        </div>
        <form class="flex flex-col h-full justify-between items-center bg-white md:px-12 md:py-20 max-md:px-14 max-sm:px-8 max-md:py-5 max-md:space-y-4 w-full md:w-3/5 max-md:rounded-tl-[3rem]">
            <p class="text-3xl max-md:text-2xl text-[#52a1f5] font-bold text-center">Đăng nhập</p>
            <div class="w-full">
                <p class="font-bold text-[#1d1d1d] text-sm">Tài khoản</p>
                <IconInput v-model="email" border-color="blue" type="text" placeholder="Nhập tài khoản..." class="w-full mb-6">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                        <path stroke-linecap="round" stroke-linejoin="round" d="M15.75 6a3.75 3.75 0 11-7.5 0 3.75 3.75 0 017.5 0zM4.501 20.118a7.5 7.5 0 0114.998 0A17.933 17.933 0 0112 21.75c-2.676 0-5.216-.584-7.499-1.632z" />
                    </svg>
                </IconInput>
                <p class="font-bold text-[#1d1d1d] text-sm">Mật khẩu</p>
                <IconInput v-model="password" border-color="blue" autocomplete="on" type="password" placeholder="Nhập mật khẩu..." class="w-full mb-4">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                        <path stroke-linecap="round" stroke-linejoin="round" d="M16.5 10.5V6.75a4.5 4.5 0 10-9 0v3.75m-.75 11.25h10.5a2.25 2.25 0 002.25-2.25v-6.75a2.25 2.25 0 00-2.25-2.25H6.75a2.25 2.25 0 00-2.25 2.25v6.75a2.25 2.25 0 002.25 2.25z" />
                    </svg>
                </IconInput>
                <div class="text-red-500 space-x-2" v-if="wrongInfo">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6 inline-block mb-1">
                        <path stroke-linecap="round" stroke-linejoin="round" d="M12 9v3.75m9-.75a9 9 0 11-18 0 9 9 0 0118 0zm-9 3.75h.008v.008H12v-.008z" />
                    </svg>
                    <span class="text-left font-semibold inline-block">Sai thông tin đăng nhập</span>
                </div>
            </div>
            <button 
                @click.prevent="signIn"
                class="relative shadow-md max-md:w-full max-md:rounded-lg text-lg group font-semibold text-white flex justify-center items-center bg-[#52a1f5] overflow-hidden px-6 py-2.5 rounded-full transition-all duration-300 ease-in-out hover:bg-[#3d96f5] active:bg-[#2d8ef7]"
            >
                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.75" stroke="currentColor" class="w-6 h-6 ml-1 absolute transition-transform duration-300 ease-in-out -translate-x-32 group-hover:-translate-x-0 max-md:hidden">
                    <path stroke-linecap="round" stroke-linejoin="round" d="M15.75 9V5.25A2.25 2.25 0 0013.5 3h-6a2.25 2.25 0 00-2.25 2.25v13.5A2.25 2.25 0 007.5 21h6a2.25 2.25 0 002.25-2.25V15m3 0l3-3m0 0l-3-3m3 3H9" />
                </svg>
                <p class="transition-transform duration-300 ease-in-out md:group-hover:translate-x-32">Đăng nhập</p>
            </button>
            <p class="md:hidden">
                New user?
                <RouterLink to="/auth/register">
                    <span class="underline underline-offset-2 text-[#39c0c8] cursor-pointer">Register</span>
                </RouterLink>
            </p>
        </form>
        <img :src="img" class="h-[10rem] absolute ml-[calc(60%-5rem)] max-md:hidden"/>
        <div class="px-10 py-5 space-y-6 h-full text-center flex text-white flex-col justify-center items-center bg-gradient-to-tr hover:bg-gradient-to-bl w-2/5 max-md:hidden">
            <p class="font-bold text-3xl">Xin chào</p>
            <p class="text-lg font-light">Mời bạn nhập tài khoản và mật khẩu để đăng nhập vào hệ thống</p>
        </div>
    </div>
</template>