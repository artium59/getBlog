<template>
  <div class="text-center">
    <!-- aside -->
    <v-app id="inspire">
      <v-navigation-drawer v-model="drawer" app>
        <v-list dense>
          <v-list-item link>
            <v-list-item-action>
              <v-icon>mdi-home</v-icon>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title>Home</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <v-list-item link>
            <v-list-item-action>
              <v-icon>mdi-email</v-icon>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title>Contact</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>
      </v-navigation-drawer>

      <!-- navbar -->
      <v-app-bar app color="indigo" dark>
        <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
        <v-toolbar-title>Application</v-toolbar-title>
      </v-app-bar>
      <!-- main -->
      <v-main>
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
                        onclick="document.execCommand('createImages')"
                      >
                        <v-btn
                          :href="source"
                          icon
                          medium
                          target="_blank"
                          onclick="document.execCommand('createImages')"
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
                      <template v-slot:activator="{ on }" onclick="document.execCommand('Undo')">
                        <v-btn
                          :href="source"
                          icon
                          medium
                          target="_blank"
                          onclick="document.execCommand('Undo')"
                          v-on="on"
                        >
                          <input type="button" class="Undo" />
                          <i class="fas fa-undo"></i>
                        </v-btn>
                      </template>
                      <span class="Undo">Undo</span>
                    </v-tooltip>

                    <!-- redo -->
                    <v-tooltip top>
                      <template v-slot:activator="{ on }" onclick="document.execCommand('Redo')">
                        <v-btn
                          :href="source"
                          icon
                          medium
                          target="_blank"
                          onclick="document.execCommand('Redo')"
                          v-on="on"
                        >
                          <input type="button" class="Redo" />
                          <i class="fas fa-redo"></i>
                        </v-btn>
                      </template>
                      <span class="Redo">Redo</span>
                    </v-tooltip>

                    <!-- images -->
                    |
                    <v-tooltip top>
                      <template v-slot:activator="{ on }" onclick="document.execCommand('Images')">
                        <v-btn
                          :href="source"
                          icon
                          medium
                          target="_blank"
                          onclick="document.execCommand('images')"
                          v-on="on"
                        >
                          <input type="button" class="Imgaes" />
                          <i class="fas fa-images"></i>
                        </v-btn>
                      </template>
                      <span class="Images">Images</span>
                    </v-tooltip>

                    <!-- link -->
                    <v-tooltip top>
                      <template v-slot:activator="{ on }" onclick="document.execCommand('Link')">
                        <v-btn
                          :href="source"
                          icon
                          medium
                          target="_blank"
                          onclick="document.execCommand('Link')"
                          v-on="on"
                        >
                          <input type="button" class="Link" />
                          <i class="fas fa-link"></i>
                        </v-btn>
                      </template>
                      <span class="Link">Link</span>
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
                    <div class="buttons">
                      <input
                        v-if="html_switch===true"
                        class="btn btn-primary m-1"
                        type="button"
                        value="에디터로 보기"
                        @click="convertToEditor"
                      />
                      <input
                        v-if="html_switch===false"
                        class="btn btn-primary m-1"
                        type="button"
                        value="HTML로 보기"
                        @click="convertToHTML"
                      />
                    </div>
                  </v-row>

                  <div class="col-1-none"></div>
                  <div class="mytexarea border border-danger col-11">
                    <div class="editortext editorDIV" contenteditable="true"></div>
                    <div class="editorHTMLDIV"></div>
                  </div>
                </div>
              </div>

              <div class="buttons">
                <input
                  v-if="html_switch===true"
                  class="btn btn-primary m-1"
                  type="button"
                  value="에디터로 보기"
                  @click="convertToEditor"
                />
                <input
                  v-if="html_switch===false"
                  class="btn btn-primary m-1"
                  type="button"
                  value="HTML로 보기"
                  @click="convertToHTML"
                />
              </div>
            </v-col>
          </v-row>
        </v-container>
        <button class="btn btn-primary m-4">글쓰기</button>
        <button class="btn btn-primary m-4">취소</button>
      </v-main>
    </v-app>
  </div>
</template>

<script>
import $ from "jquery";

$(document).ready(function () {
  $(".editorHTMLDIV").hide();
});

//HTML코드로 보기

//에디터 화면으로 보기
export default {
  name: "List2",
  props: {
    source: String,
  },
  data: () => ({
    html_switch: false,
    drawer: null,
  }),
  methods: {
    convertToHTML: function () {
      this.html_switch = true;
      $(".editorHTMLDIV").text($(".editorDIV").html());
      $(".editorHTMLDIV").show();
      $(".editorDIV").hide();
    },
    convertToEditor: function () {
      this.html_switch = false;
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