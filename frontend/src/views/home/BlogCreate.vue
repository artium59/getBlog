<template>
  <div>
    <Navbar />
    <div class="container mt-3">
    <BlogList />
      <div class="input-group flex-nowrap mt-2">
        <div class="input-group-prepend">
          <span class="input-group-text" id="addon-wrapping">블로그Get</span>
        </div>
        <input type="text" class="form-control" placeholder="블로그 이름을 입력하세요." aria-label="Username" aria-describedby="addon-wrapping">
      </div>
      <div class="input-group mb-3 mt-2">
        <div class="input-group-prepend">
          <label class="input-group-text" for="inputGroupSelect01">디자인Get</label>
        </div>
        <select class="custom-select" id="inputGroupSelect01">
          <option selected>원하는 template을 고르세요.</option>
          <option value="1">template1</option>
          <option value="2">template2</option>
          <option value="3">template3</option>
        </select>
        <button class="ml-1 B-CreateBtn">Get</button>
      </div>
    </div>
  </div>
</template>

<script>
// import Main from '@/views/home/Main.vue'
import Navbar from '@/components/homepage/Navbar.vue'
import BlogList from '@/components/homepage/BlogList.vue'

export default {
  name:'blogcreate',
  components:{
    Navbar,
    BlogList,
  }
}
</script>

<style>
.B-CreateBtn {
  background-color: lightgrey;
  border : lightgray;
  
}
</style>