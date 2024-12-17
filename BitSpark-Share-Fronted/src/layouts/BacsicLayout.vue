<template>
  <div id="basicLayout">
    <a-layout style="min-height: 100vh">
      <a-layout-header class="header">
        <GlobalHeader />
      </a-layout-header>
      <a-layout-content class="content">
        <router-view></router-view>
      </a-layout-content>
      <a-layout-footer class="footer">
        <a href="https://www.bitspark.live" target="_blank" class="footer-link">BitSpark 数字火花</a>
      </a-layout-footer>
    </a-layout>
  </div>
</template>

<script setup lang="ts">
import GlobalHeader from '@/components/GlobalHeader.vue'
</script>

<style scoped>
/* 通用布局优化 */
#basicLayout {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}

#basicLayout header {
  padding: 0 20px;
  background: #f0f2f5;
  color: unset;
  margin-bottom: 16px;
  border-bottom: 1px solid #dcdfe6; /* 添加分隔线，提升层次感 */
}

#basicLayout .content {
  padding: 20px;
  background: linear-gradient(to right, #fefefe, #fff); /* 更加柔和的渐变效果 */
  flex-grow: 1; /* 使内容区域自适应填充 */
}

#basicLayout .footer {
  background: #282c34; /* 深色背景，增强对比 */
  padding: 16px 0;
  text-align: center;
  color: #fff;
  font-size: 14px;
  border-top: 1px solid #444; /* 增加分隔感 */
}

#basicLayout .footer .footer-link {
  color: #61dafb; /* 链接颜色 */
  text-decoration: none;
  font-weight: bold;
}

#basicLayout .footer .footer-link:hover {
  text-decoration: underline;
  color: #21a1f1; /* hover时修改颜色 */
}

/* 响应式设计 */
@media (max-width: 768px) {
  #basicLayout .footer {
    padding: 12px;
    font-size: 12px;
  }

  #basicLayout .content {
    padding: 16px;
  }

  #basicLayout header {
    padding: 0 16px; /* 更小的内边距以适应小屏幕 */
  }
}
</style>
