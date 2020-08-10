<template>
  <div>
    <div class="container mt-3">
    <BlogList />
      <div class="input-group flex-nowrap mt-2">
        <div class="input-group-prepend">
          <span class="input-group-text" id="addon-wrapping">블로그Get</span>
        </div>
        <input v-model="selectedData.name" type="text" class="form-control" placeholder="블로그 이름을 입력하세요." aria-label="Username" aria-describedby="addon-wrapping">
      </div>
      <div class="input-group mb-3 mt-2">
        <div class="input-group-prepend">
          <label class="input-group-text" for="inputGroupSelect01">디자인Get</label>
        </div>
        <select v-model="selectedData.selected" class="custom-select" id="inputGroupSelect01">
          <option selected>원하는 template을 고르세요.</option>
          <option value="1">template1</option>
          <option value="2">template2</option>
          <option value="3">template3</option>
        </select>
      </div>
        <!-- <button @click="moveToblog(selectedData)" class="ml-1 B-CreateBtn">Get</button> -->
        <v-btn @click="moveToblog(selectedData)" x-large color="success" dark>시작하기</v-btn>
    </div>
  </div>
</template>

<script>
// import Main from '@/views/home/Main.vue'
import BlogList from '@/components/homepage/BlogList.vue'
import { mapActions } from 'vuex'

export default {
  name:'blogcreate',
  components:{
    BlogList,
  },
  data() {
    return {
      selectedData: {
        selected: '',
        name: '',
      }
    }
  },
  methods: {
    ...mapActions(['moveToblog'])
  },
  mounted() {
    this.$store.state.renderNum = 0
  }
}
</script>

<style>
.B-CreateBtn {
  background-color: rgb(110, 92, 92);
  border : lightgray;
  
}
</style>