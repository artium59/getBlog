<template>
  <div>삭제중...</div>
</template>

<script>
import http from '@/util/http-common';
export default {
  name: 'Delete',
  created() {
    http
      .delete(`/api/post/${this.$route.query.pno}`)
      .then(() => {
        alert('삭제가 완료되었습니다.');
        this.$router.push('/');
      })
      .catch(() => {
        alert('삭제 처리시 에러가 발생했습니다.');
      });
  },
};
</script>

<style></style>
