<template>
  <div id = "globalHeader">
    <router-link to="/">
      <div class="title-bar">
        <img src="../assets/logo.png" alt="logo" class="logo"/>
        <div class="title">BitSpark</div>
      </div>
    </router-link>
    <a-menu v-model:selectedKey = "current" mode="horizontal" :items="items" />
    <div>
      <a-button type="primary">登入</a-button>
    </div>
  </div>
</template>
<script lang="ts" setup>
import { h, ref } from 'vue';
import {BankTwoTone} from '@ant-design/icons-vue';
import {MenuProps} from 'ant-design-vue';
const current = ref<string[]>(['mail']);
const items = ref<MenuProps['items']>([
  {
    key: '/',
    icon: () => h(BankTwoTone),
    label: '主页',
    title: '主页',
  },
  {
    key: '/about',
    label: '关于',
    title: '关于',
  },
  {
    key: 'others',
    label: h('a', { href: 'https://bitspark.live', target: '_blank' }, 'BitSpark 数字火花'),
    title: 'BitSpark 数字火花',
  },
]);
</script>

<style scoped>
#globalHeader .title-bar{
  display: flex;
  align-items: center;
}
.title{
  color: black;
}
</style>

