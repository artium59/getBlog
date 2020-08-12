<template>
  <div class="Edit">
    <button class="btn btn-primary" @click="myMarkDown">가자</button>
    <div id="markdown" contenteditable></div>
    <div v-if="text">{{ text }}</div><br>
    <div v-if="text" >{{ markdown }}</div>

    <div v-else>위에 내용을 적어주세요</div>
    <br />
  </div>
</template>

<script>
export default {
  name: "Edit",
  data: function () {
    return {
      text: "",
      result: "",
      markdown: "",
    };
  },
  methods: {
    myMarkDown() {
      this.text = document.getElementById("markdown").innerText;
      this.H2 = this.text.replace(/[#]{2}/g, "");
      this.markdown = "<h2>" + this.H2 + "</h2>"

      
    },
  },
  
};
</script>

<style scoped>
.Edit {
  margin: 50px;
}
</style>