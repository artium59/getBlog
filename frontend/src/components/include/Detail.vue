<template>
  <div>
    <h1>여기에 글 정보</h1>
    <hr />
    <br />
    <br />
    <h1>title : {{ post.title }}</h1>
    <br />
    <!-- <h4>{{ nickname }}</h4> -->
    <br />
    <h4>content : {{ post.content }}</h4>
    <br />
    <br />
    <hr />
    <div class="text-center">
      <router-link to="/"
        ><button class="btn btn-primary" id="listBtn">목록</button></router-link
      >&nbsp;
      <router-link :to="'/update?pno=' + post.pno"
        ><button class="btn btn-primary" id="updateBtn">수정</button></router-link
      >
      <router-link :to="'/delete?pno=' + post.pno"
        ><button class="btn btn-primary" id="deleteBtn">삭제</button></router-link
      >
    </div>
    <br />
    <br />

    <!-- 댓글 리스트 -->
    댓글
    <hr />
    <div class="media container" v-for="(item, index) in replies" :key="index + '_replies'">
      <img
        src="https://lh4.googleusercontent.com/proxy/gt2zedUM7WSUSi0IFaUweagmtganvNSRnkR2LZBuTlg-awQyO8sbZBibRcK7klnwx_8uM5djgeiWsMfpD5xJI_GtpZijxoH0qrAv0Srp4GWwu6UqKafqJf53xgPXEg80qFzA3DvlQcHlYFq6G-OFFhxLrQ"
        class="mr-3 read-icon rounded-circle"
        alt="..."
      />
      <div class="media-body">
        <h5 class="mt-0">{{item.replyer}}</h5>{{getFormatDate(item.createDate)}}
        <p>{{item.replytext}}</p>
      </div>
      <button class="btn btn-primary" id="ReplyeditBtn" @click="editHandler">수정</button>
      <button class="btn btn-primary" id="ReplydelBtn" @click="deleteHandler(item.rno)">삭제</button>
    </div>
    <hr />

    <template>
      <div>
		<div>
	<input type="text" name="replyer" id="replyer" placeholder="작성자" v-model="replyer"/>
		</div>
		<div>
	<textarea name="replytext" id="replytext" cols="20" rows="3" placeholder="댓글 입력" v-model="replytext"></textarea>
		</div>
		<button class="btn btn-primary" id="ReplyAddBtn" @click="addHandler">등록</button>
	</div>
    </template>
  </div>
</template>

<script>
import moment from 'moment';
import { mapGetters } from 'vuex';
export default {
  name: 'Detail',
  props: {
    type: {type: String},
  },
  computed: {
    ...mapGetters(['post']),
  },
  data: function(){
    return {
      nickname: '',
      replies: [],
      rno: '',
      pno: '',
      replytext: '',
      replyer: '',
      createDate: '',
    };
  },
  created(){
    this.getNickname(),
    this.getReplies()
  },
  methods: {
    getFormatDate(createDate) {
      return moment(new Date(createDate)).format('YYYY.MM.DD HH:MM:SS');
    },
    getNickname(){
      this.$http.get(`${this.$store.state.HOST}/api/post/detail/${this.$route.query.pno}`)
        .then(({ data }) => {
          this.nickname = data;
        })
        .catch(() => {
          console.log('에러가 발생했습니다.');
        });
    },
    getReplies(){
      this.$http.get(`${this.$store.state.HOST}/api/reply/list/${this.$route.query.pno}`)
        .then(response => {
          console.log(response);
          this.replies = response.data;
        })
        .catch((err) => {
          console.log(err);
          console.log('에러가 발생했습니다.');
        });
    },
    addHandler(){
      this.$http.post(`${this.$store.state.HOST}/api/reply/insert`, {
          rno: this.rno,
          pno: this.$route.query.pno,
          replytext: this.replytext,
          replyer: this.replyer,
          createDate: this.createDate,
        })
        .then(response => {
          alert('등록이 완료되었습니다.');
          console.log(response)
          this.$router.go()
        })
        .catch(() => {
          alert('등록 처리시 에러가 발생했습니다.');
        });
    },
    editHandler(){

    },
    deleteHandler(rno){
    this.$http.delete(`${this.$store.state.HOST}/api/reply/`+rno)
      .then(response => {
        alert('삭제가 완료되었습니다.')
        console.log(response)
        this.$router.go()
      })
      .catch(() => {
        alert('삭제 처리시 에러가 발생했습니다.');
      });
    }
  },
};
</script>

<style>
.read-icon {
  height: 6ch;
  width: 6ch;
  margin: 0px;
  margin-right: 10px;
}
.media {
    padding: 0;
    margin: 0;
    margin-left: 6%;
}
.media-body {
    text-align: left;
}
</style>