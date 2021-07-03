# SpringBootサンプルアプリケーション

# 概要
SpringBoot学習用のソースコードになります。

# 各ファイルの説明

## com.example.demo.controller.ErrorResponse.java
エラー発生時の情報をモデリングしたクラスです。

## com.example.demo.controller.RequestApiController.java
SpringBootから他APIへのGET・POSTアクセス処理を記述しています。

## com.example.demo.controller.RestExceptionHandler.java
SpringBootのControllerで発生したエラーを受け取る集約例外クラスです。  
※Controllerを横断して受取可能です。

## com.example.demo.controller.SampleRestApiController.java
GET・POST受け取りの基本的な処理を記述しています。

## com.example.demo.controller.WebApiController.java.java
GET・POSTを受け取り、JSON・ファイルを返却するAPI処理を記述しています。

## com.example.demo.controller.TestModel.java
JSON返却情報をマッピングしたクラスです。

## com.example.demo.controller.view.WhatTimeIsItController.java
「http://localhost:8080/view/what-time-is-it/」の描画処理を行います。  
対応するviewは「/src/mainresources/templates.wii.html」にThymeleafを使用して記述しています。

## com.example.demo.controller.TemplateController.java
Thymeleafエンジンを使用して文字列を生成します。  

### テンプレートファイルからの生成
生成対象のテンプレートは「src/main/resources/templates/messages/hoge.message」になります。  
エンドポイント: http://localhost:8080/template/test

### 文字列からの生成
エンドポイント: http://localhost:8080/template/test/string/hogehoge
