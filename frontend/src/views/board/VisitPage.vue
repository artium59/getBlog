<template>
    <div>
        <p>글목록</p>
        <ul v-for="list in visitlist" :key="list" class="mylist">
            <li>{{ list }}</li>
            <hr>
        </ul>

        <!-- <ul class="list-group list-group-flush" v-for="list in visitlist" :key='list'>
            <li class="list-group-item">{{ list }}</li>
            <hr>
        </ul> -->
        <!-- {{ visitlist }} -->
        
    </div>
</template>

<script>

export default {
    name: 'VisitPage',
    props: {
        visitlist: Array
    },
    // methods: {
    //     visitlist() {
    //         this.$emit('visit')
    //     }
    // }
    // components :{

    // },
    // data() {
    //     return {
    //         // messageFromCreate: this.$route.query.message
    //     }
    // }
}

</script>

<style scoped>
.mylist {
    list-style: none;
    padding-inline-start: 0px;
}
</style>