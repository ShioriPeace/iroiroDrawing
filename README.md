## はじめに
- 3/18からiroiromemorial→iroiroDrawingに移行

## 課題
### カメラ
- カメラが横に引き伸ばされている   
~~2.  カメラをタッチしても写真が**1回しか**保存されない~~ →4/23解決

### お絵かき　
- 線の太さが一定  
~~1. 書いていた線の色が一気に変わる~~ →4/9解決

## 進捗
### 4/3
- 真ん中以外を触ると落ちることが判明  
→はじの方を触ると落ちる  
　→端の範囲を広げるか、枠組みを作るか
→解決  
 if (y + height > source.getHeight()) {
            throw new IllegalArgumentException("y + height must be <= bitmap.height()");
        }  
        こいつが原因だった
        →タッチした時のyの値を-400にしてみたら、範囲内に収まった

### 4/5
- 色が正しく出るようになったヽ(´▽｀)/  
[参考にした神ページ](https://stackoverflow.com/questions/5669501/how-do-you-get-the-rgb-values-from-a-bitmap-on-an-android-device)





