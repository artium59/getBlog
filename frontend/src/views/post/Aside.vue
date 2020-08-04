<template>
  <div class="aside">
    <div class="container">
      <router-link to="/">분류 전체 보기</router-link><br>
      <div class="aside-top"><a href="#services" class="aside-top">최근 인기글</a></div><br>
      <div class="aside-top"><a href="#clients" >최근 댓글</a></div>
      <div class="aside-top"><a href="#contact" class="aside-top">태그</a></div>
      <hr class="aside-hr">
      이런것도 되게할수있을까<br>연습 블로그<br>
      <h4>전체 방문자 : 0</h4>

      <h4>Today : 0</h4>

      <h4>Yesterday : 0</h4>
    </div>
  </div>
</template>

<script>
export default {
  name: "Aside",
};
</script>
<style scoped>
.aside {
  width: auto;
  padding-top: 20%;
  border-left: 0.1em solid #eee;
  padding: 0.5em;
}
.aside-top {
  justify-content: center;
  align-content: space-around;
  height: 100%;
  margin-bottom: 20px;
  padding-bottom: 50px;
}
.aside-hr {
  width: 200px;
}
</style>