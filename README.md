# SimpleMediaUi
Simple all in one media player Ui, base on Java

**Screenshots**
![settings](https://user-images.githubusercontent.com/101990722/162588327-b5c653f4-a741-4ebb-b6e7-2fa2baf1778d.png)
![preview](https://user-images.githubusercontent.com/101990722/162588335-0ae2a71c-e90f-4cbc-8626-7e083fa5a5df.png)

## Installation
- Clone this repo and open with [Intellij Idea](https://www.jetbrains.com/idea/) or your favourite java IDE.
- Install [Java Platform, Standard Edition Development Kit](https://www.oracle.com/java/technologies/downloads/#java17) (jdk) version 11 or higher.
- Download [javafx](https://openjfx.io/). (javafx version depend on your jdk version).
- Download [jfoenix library](http://www.jfoenix.com/)
- Open `File` >> `Project Structure` >> `Libraries` and add javafx library and jfoenix.

![fx](https://user-images.githubusercontent.com/101990722/162588663-a318731e-92c9-45c3-86c2-5fbc82c295e2.png)

***

Now Configure Virtual machine.

- Go to `Run` >> `Edit Configuration` and add javafx modules.

![vm](https://user-images.githubusercontent.com/101990722/162588778-b2604b2a-94bf-4ae6-8689-5544af05229b.png)

```
--module-path "/path/to/"
--add-modules javafx.controls,javafx.fxml,javafx.media
```

- If something wrong, use with [Maven](https://mvnrepository.com/search?q=javafx)

```
<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-controls</artifactId>
    <version>17.0.0.1</version>
</dependency>
```
