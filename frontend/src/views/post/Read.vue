<template>
  <div>
    <detail />
  </div>
</template>

<script>
import Detail from '@/components/include/Detail.vue';
export default {
  name: 'Read',
  components: {
    Detail,
  },
  created() {
    this.$store.dispatch('getPOST', `/api/post/${this.$route.query.pno}`);
  },
};
</script>

<style></style>
