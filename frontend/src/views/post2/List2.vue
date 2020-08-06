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
                <div class="d-flex justify-content-between">
                  <!-- buttons -->
                  <v-row class="editorbuttons">
                    <v-tooltip top>
                      <template
                        class="BOLD"
                        v-slot:activator="{ on }"
                        onclick="document.execCommand('bold')"
                      >
                        <v-btn
                          :href="source"
                          onclick="document.execCommand('bold')"
                          icon
                          large
                          target="_blank"
                          v-on="on"
                        >
                          <input type="button" class="BOLD" value="B" />
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
                          large
                          target="_blank"
                          onclick="document.execCommand('Italic')"
                          v-on="on"
                        >
                          <input type="button" class="ITALIC" value="Italic" />
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
                          large
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
                          large
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
                    <v-tooltip top>
                      <template
                        class="BOLD asdf"
                        v-slot:activator="{ on }"
                        onclick="document.execCommand('bold')"
                      >
                        <v-btn
                          :href="source"
                          icon
                          large
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
                          large
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
                          large
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
                    <div class="editorHTMLDIV" value="<br><br>"></div>
                  </div>

                </div>
              </div>

              <div class="buttons">
                <input type="button" value="에디터로 보기" onclick="convertToEditor()" />
                <input type="button" value="HTML로 보기" onclick="convertToHTML()" />
              </div>
            </v-col>
          </v-row>
        </v-container>
      </v-main>
      <v-footer color="indigo" app>
        <span class="white--text">&copy; {{ new Date().getFullYear() }}</span>
      </v-footer>
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
    drawer: null,
  }),
  methods: {
    convertToEditor() {
      $(".editorDIV").html($(".editorHTMLDIV").text());
      $(".editorDIV").show();
      $(".editorHTMLDIV").hide();
    },
    convertToHTML() {
      $(".editorHTMLDIV").text($(".editorDIV").html());
      $(".editorHTMLDIV").show();
      $(".editorDIV").hide();
    },
  },
};
</script>

<style scoped>
.editorbuttons {
  flex-direction: column;
  position: fixed;
  top: 20%;
  height: 50%;
  align-items: center;
  justify-content: center;
}
.mytexarea {
  width: 95%;
}
</style>