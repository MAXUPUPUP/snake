<template>
    <div class="playground">
        <GameMap />
    </div>

</template>

<script>
import GameMap from './GameMap.vue'

export default{
    components: {
        GameMap,
    }
}

</script>

<style scoped>

div.playground {
    width: 40vw;
    height: 50vh;
    margin: 150px auto;
}
</style>