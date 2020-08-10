<template>
    <div class="user">
        <div class="table">

            <div class="middle">
                <div style="text-align: center; color: red; font-size: 40px; margin-bottom: 5%;">
                    <h1>ERROR</h1>
                </div>
                <h1>Sorry, this page isn't available.</h1>
                <h4>The link you followed may be broken, or the page may have been removed.</h4>
                <div style="margin-top: 5%;">
                    <div class="wrap">
                        <router-link to='/' class="btn--text">
                            <div style="text-align: center; font-size: 20px;">
                                <h1>GO MAIN</h1>
                            </div>
                        </router-link>
                    </div>
                </div>
            </div>

        </div>
    </div>
</template>

<script>
    import constants from '../../lib/constants'

    export default {
        components: {
        },
        created(){
        },
        watch: {
        },
        methods: {
        },
        data: () => {
            return {
                constants
            }
        }
    }
</script>