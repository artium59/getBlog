<template>
  <div>
    <b-carousel
      id="carousel-1"
      v-model="slide"
      :interval="4000"
      controls
      indicators
      background="#ababab"
      img-width="1024"
      img-height="480"
      style="text-shadow: 1px 1px 2px #333;"
      @sliding-start="onSlideStart"
      @sliding-end="onSlideEnd"
    >
      <!-- Text slides with image -->
      <b-carousel-slide
        caption="GetBlog"
        text="여러가지 블로그를 얻어가세요."
        img-src="https://images.unsplash.com/photo-1589652717521-10c0d092dea9?ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80"
      ></b-carousel-slide>

      <!-- Slides with custom text -->
      <b-carousel-slide img-src="https://images.unsplash.com/photo-1472289065668-ce650ac443d2?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80">
        <h1 class="post">당신만의 블로그를 <br>제작해보세요!</h1>
      </b-carousel-slide>

      <!-- Slides with image only -->
      <b-carousel-slide img-src="https://images.unsplash.com/photo-1497005367839-6e852de72767?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjF9&auto=format&fit=crop&w=1047&q=80">
        
      <div class="signBtn">
          <h2>회원가입</h2>
      </div>
      </b-carousel-slide>
    </b-carousel>
  </div>
</template>

<script>

export default {
  name: 'Main',
  components: {
  },

}
</script>

<style>
#carousel-1 {
  width: 100%;
  height: auto;
}
.signBtn {
  background-color:rgb(36, 33, 33);
  width: 50%;
  height: auto;
  border-radius: 20px;
  position: relative;
  left:400px;
  bottom: 270px;
}
.post {
  position: relative;
  left:400px;
  bottom:270px;
}
/* .ddd {
  right: 20%;
  height:auto;
} */
</style>
