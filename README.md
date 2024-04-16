# コインゲーム

Java の練習として実装したゲームです。

<p style="display: inline">
  <img src="https://img.shields.io/badge/-Java-4479A1.svg?logo=java&style=for-the-badge">
</p>

## 概要

カードピックゲーム：1〜10の番号が書かれたカードで構成されたデッキが2つあり、それぞれのデッキから1枚ずつカードを引き、その合計値が11以上かどうかで勝敗を判定します。 勝利の場合はコインを獲得し、敗北の場合は所持コインが減ることになるシンプルなゲームです。

ハイ＆ローゲーム：カードピックゲームで勝利した場合に、獲得したコインをベットして開始できるゲームです。まずはカードを1枚引きます。その次に引くカードの番号が、最初に引いたカードよりも大きいか小さいかを予想します。予想が当たった場合はカードピックゲームで獲得したコインを増やすことができ、外れた場合は獲得コインが0枚になります。

## 環境

<!-- 言語、フレームワーク、ミドルウェア、インフラの一覧とバージョンを記載 -->

| 言語・フレームワーク  | バージョン |
| ------------------ | ---------- |
| Java               | 1.8.0_401  |

## ディレクトリ構成

<!-- Treeコマンドを使ってディレクトリ構成を記載 -->

$ tree .  
.  
├── README.md  
└── src  
&emsp;&emsp;&emsp;├── Playing.java  
&emsp;&emsp;&emsp;└── util  
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;├── CardPickGame.java  
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;├── GameUtils.java  
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;└── HighAndLowGame.java  


## 実行方法

$ javac -encoding UTF-8 ./Playing.java  
$ javac -encoding UTF-8 ./util/GameUtils.java  
$ javac -encoding UTF-8 ./util/CardPickGame.java  
$ javac -encoding UTF-8 ./util/HighAndLowGame.java  

$ java ./Playing
