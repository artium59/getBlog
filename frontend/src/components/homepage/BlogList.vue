<template>
  <b-container fluid class="p-4 bg-light">
  <b-row>
    <b-col>
      <img src="@/assets/template/tmp1.png" alt="Template1" class="img-thumbnail">
      <p>template1</p>
    </b-col>
    <b-col>
      <img src="@/assets/template/tmp2.png" alt="Template2" class="img-thumbnail">
      <p>template2</p>
    </b-col>
    <b-col>
      <img src="@/assets/template/tmp3.png" alt="Template3" class="img-thumbnail">
      <p>template3</p>
    </b-col>
  </b-row>
</b-container>
</template>

<script>
export default {
    name: 'BlogList'
}  
</script>

<style scoped>
img {
  width:100%;
  height: 100%;
}
p {
  margin-top:5px;
}

</style>