<template>
  <div>
    <Navbar />
    <!-- <div class="container"> -->
        <Carousel />
        <BlogList />    
    <!-- </div> -->
    <footer>
        <p>Copyright @2020 Getblog.com All rights reserved.</p>
    </footer>
  </div>
</template>

<script>
// @ is an alias to /src
import Navbar from '@/components/homepage/Navbar.vue'
import Carousel from '@/components/homepage/Carousel.vue'
import BlogList from '@/components/homepage/BlogList.vue'
export default {
  name: 'Main',
  components: {
    Navbar,
    Carousel,
    BlogList,
  },
  data() {
      return {
        slide: 0,
        sliding: null,
      }
    },
  // methods: {
  //   onSlideStart(slide) {
  //     this.sliding = true
  //   },
  //   onSlideEnd(slide) {
  //     this.sliding = false
  //   }
  // }
}
</script>

<style>

</style>
