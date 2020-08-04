<template>
    <div class='container pt-5' id="visit">
        <div class="form-group">
            <label for="exampleFormControlTextarea1" class="font-weight-bold text-info text-align-left">방명록</label>
            <hr class="m-auto"> <br>
            <textarea class="form-control m-auto " id="exampleFormControlTextarea1" rows="3" v-model="content"></textarea>
        </div>
        <div class='text-right'>
            <button type="submit" class="btn btn-info" @click="createVisit">커밋찍고감</button>
        </div>
        <VisitPage :visitlist="visitlist"/>
    </div>
    
</template>

<script>
import VisitPage from '@/views/board/VisitPage.vue'
export default {
    name: 'VisitCreate',
    data() {
        return {
            content: '',
            visitlist: [],
        }
    },
    components: {
        VisitPage,
    },
    methods: {
        createVisit() {
            this.visitlist.push(this.content)
            this.content = null

        }
    }
}

</script>

<style scoped>

#visit {
    width: 50%;
}
</style>