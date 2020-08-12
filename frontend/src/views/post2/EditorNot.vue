<template>
  <div id="Edit2" v-cloak>
    <v-container class="fill-height" fluid>
      <v-row align="center" justify="center">
        <v-col class="text-center">
          <div class="mybuttons border border-primary">
            <!-- Bold -->
            <div class="justify-content-between">
              <!-- buttons -->
              <v-row class="editorbuttons">
                <v-tooltip top>
                  <!-- Bold -->
                  <template
                    class="BOLD"
                    v-slot:activator="{ on }"
                    onclick="document.execCommand('bold')"
                  >
                    <v-btn
                      class="ml-4"
                      :href="source"
                      onclick="document.execCommand('bold')"
                      icon
                      medium
                      target="_blank"
                      v-on="on"
                    >
                      <input type="button" class="BOLD" />
                      <i class="fas fa-bold"></i>
                    </v-btn>
                  </template>
                  <span>Bold</span>
                </v-tooltip>

                <!-- Italic -->
                <v-tooltip top>
                  <template
                    class="BOLD"
                    v-slot:activator="{ on }"
                    onclick="document.execCommand('bold')"
                  >
                    <v-btn
                      :href="source"
                      icon
                      medium
                      target="_blank"
                      onclick="document.execCommand('Italic')"
                      v-on="on"
                    >
                      <input type="button" class="ITALIC" />
                      <i class="fas fa-italic"></i>
                    </v-btn>
                  </template>
                  <span>Italic</span>
                </v-tooltip>

                <!-- UNDERBAR -->

                <v-tooltip top>
                  <template
                    class="BOLD"
                    v-slot:activator="{ on }"
                    onclick="document.execCommand('bold')"
                  >
                    <v-btn
                      :href="source"
                      icon
                      medium
                      target="_blank"
                      onclick="document.execCommand('Underline')"
                      v-on="on"
                    >
                      <input type="button" class="BAR" />
                      <i class="fas fa-underline"></i>
                    </v-btn>
                  </template>
                  <span class="UNDERBAR">underbar</span>
                </v-tooltip>

                <!-- BAR -->
                <v-tooltip top>
                  <template
                    class="BOLD"
                    v-slot:activator="{ on }"
                    onclick="document.execCommand('bold')"
                  >
                    <v-btn
                      :href="source"
                      icon
                      medium
                      target="_blank"
                      onclick="document.execCommand('StrikeThrough')"
                      v-on="on"
                    >
                      <input type="button" class="BAR" />
                      <i class="fas fa-strikethrough"></i>
                    </v-btn>
                  </template>
                  <span class="strikethrough">strikethrough</span>
                </v-tooltip>
                
                <!-- Undo -->
                |
                <v-tooltip top>
                  <template
                    v-slot:activator="{ on }"
                    onclick="document.execCommand('bold')"
                  >
                    <v-btn
                      :href="source"
                      icon
                      medium
                      target="_blank"
                      onclick="document.execCommand('StrikeThrough')"
                      v-on="on"
                    >
                      <input type="button" class="BAR" />
                      <i class="fas fa-strikethrough"></i>
                    </v-btn>
                  </template>
                  <span class="strikethrough">strikethrough</span>
                </v-tooltip>


                <!-- 왼쪽 정렬 -->
                |
                <v-tooltip top>
                  <template
                    class="BOLD asdf"
                    v-slot:activator="{ on }"
                    onclick="document.execCommand('bold')"
                  >
                    <v-btn
                      :href="source"
                      icon
                      medium
                      target="_blank"
                      onclick="document.execCommand('justifyleft')"
                      v-on="on"
                    >
                      <input type="button" class="asdf" />
                      <i class="fas fa-align-left"></i>
                    </v-btn>
                  </template>
                  <span class="UNDERBAR">왼쪽 정렬</span>
                </v-tooltip>

                <!-- 가운데 정렬 -->
                <v-tooltip top>
                  <template
                    class="BOLD asdf"
                    v-slot:activator="{ on }"
                    onclick="document.execCommand('bold')"
                  >
                    <v-btn
                      :href="source"
                      icon
                      medium
                      target="_blank"
                      onclick="document.execCommand('justifycenter')"
                      v-on="on"
                    >
                      <input type="button" icon="fas fa-equals" />
                      <i class="fas fa-align-center"></i>
                    </v-btn>
                  </template>
                  <span class="UNDERBAR">가운데 정렬</span>
                </v-tooltip>

                <!-- 오른쪽 정렬 -->
                <v-tooltip top>
                  <template
                    class="BOLD asdf"
                    v-slot:activator="{ on }"
                    onclick="document.execCommand('bold')"
                  >
                    <v-btn
                      :href="source"
                      icon
                      medium
                      target="_blank"
                      onclick="document.execCommand('justifyright')"
                      v-on="on"
                    >
                      <input type="button" class="asdf" />
                      <i class="fas fa-align-right"></i>
                    </v-btn>
                  </template>
                  <span class="UNDERBAR">오른쪽 정렬</span>
                </v-tooltip>
              </v-row>

              <div class="col-1-none"></div>
              <div class="mytexarea border border-danger col-11">
                <div class="editortext editorDIV" contenteditable="true"></div>
                <div class="editorHTMLDIV" ></div>
              </div>
            </div>
          </div>

          <div class="buttons">
            <input class="btn btn-primary m-1" type="button" value="에디터로 보기" @click="convertToEditor" />
            <input class="btn btn-primary m-1" type="button" value="HTML로 보기" @click="convertToHTML" />
          </div>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import $ from "jquery";

export default {
  name: "Edit2",
  props: {
    source: String,
  },
  data: function () {
    return {};
  },
  methods: {
    convertToHTML: function () {
      $(".editorHTMLDIV").text($(".editorDIV").html());
      $(".editorHTMLDIV").show();
      $(".editorDIV").hide();
    },
    convertToEditor: function () {
      $(".editorDIV").html($(".editorHTMLDIV").text());
      $(".editorDIV").show();
      $(".editorHTMLDIV").hide();
    },
    mounted: function () {
      $(".editorHTMLDIV").hide();
    },
  },
};
</script>

<style scoped>
</style>