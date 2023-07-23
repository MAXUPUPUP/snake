<!-- 创建一个组件方便统一设计样式 -->
<template>
<div class="container content-field">
    <div class="card">
        <div class="card-body">
            <slot></slot>
        </div>
    </div>
</div>
<!-- 加一个白框 -->

</template>

<script>
</script>

<style scoped>
div.content-field{
    margin-top: 20px;
}
/* 往下移一点 */
</style>