<template>
    <div>
        <div class="imgCon">
            <img src="@/assets/main.png" alt="mainImage">
            <div class="startBtn">
                <router-link to="/blogcreate"><button type="button" class="btn btn-outline-dark">시작하기</button></router-link>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name:'main',
    mounted() {
    this.$store.state.renderNum = 0
  }
}
</script>

<style scoped>
.imgCon {
    /* width: 80vw; */

}
img {
    width: 100%;
}

.startBtn {
    margin-bottom: 5vh;
    width: 100%;
    border-radius: 1rem !important;
}

</style>