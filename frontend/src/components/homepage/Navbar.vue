<template>
  <div>
  <b-navbar toggleable="lg" type="light" variant="light" id="design">
    <b-navbar-brand href="/"><img src="@/assets/logo2.png" class="logo" alt="logoimage"></b-navbar-brand>
    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav>
        <b-nav-item href="#">BlogList</b-nav-item>
        <b-nav-item href="/blogcreate">BlogCreate</b-nav-item>
        <b-nav-item href="#">MyBlog</b-nav-item>
        <!-- <b-nav-item href="#" disabled>Disabled</b-nav-item> -->
      </b-navbar-nav>

      <!-- Right aligned nav items -->
      <b-navbar-nav class="ml-auto">
        <b-nav-form>
          <b-form-input size="sm" class="mr-sm-2" placeholder="Search"></b-form-input>
          <b-button pill size="sm" class="my-2 my-sm-0" variant="outline-dark" type="submit">Search</b-button>
        </b-nav-form>

        <!-- <b-nav-item-dropdown text="Lang" right>
          <b-dropdown-item href="#">EN</b-dropdown-item>
          <b-dropdown-item href="#">ES</b-dropdown-item>
          <b-dropdown-item href="#">RU</b-dropdown-item>
          <b-dropdown-item href="#">FA</b-dropdown-item>
        </b-nav-item-dropdown> -->

        <b-nav-item-dropdown right>
          <!-- Using 'button-content' slot -->
          <template v-slot:button-content>
            <strong><b-avatar variant="light"></b-avatar> Login</strong>
          </template>
          <b-dropdown-item href="#">Profile</b-dropdown-item>
          <b-dropdown-item href="#">Sign Out</b-dropdown-item>
        </b-nav-item-dropdown>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
</div>
</template>

<script>
export default {
    name: 'navbar'
}
</script>

<style>
/* #design {
    /* background-color:lightsteelblue !important; 
}*/
.logo {
  width:50px;
  height: 50px;
}
</style>