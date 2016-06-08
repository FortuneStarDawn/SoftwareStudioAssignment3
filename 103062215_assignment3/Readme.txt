我創了三個角色的class，都是繼承了AbstractCharacter的class。
除了原本的DefualtCharacter和Jake，新增了一個Poro。
基本上每種角色的架構大致相同，只有名稱、血量、圖像、Type不同。

在建構子裡，先將傳入的GameStage傳給gs，再將圖片利用ImageIO.read載入。
由於要有動畫效果，於是載入兩張圖片，以交替顯示的方式來做出動畫效果。

在getName裡，只要將角色的名稱回傳就好。

在initial裡，設定初始血量、Type、Skill。

最後override getImage，分為兩種情況，isActive和disActive。
當isActive的時候，兩張圖片會交替顯示。
disActive的時候，則只會顯示一張圖片。

Skill的部分，我創了一個class，繼承了AbstractSkill。

在建構子的部分，設定了Type和Power。

在launch裡，首先先產生一個0~2的整數亂數，若為0則閃避，1或2則成功，
也就是說命中率為2/3。
命中後會檢查被攻擊的角色的Type，如果和Skill的Type一樣，則只造成正常傷害。
若Type不同，則造成1.5倍的傷害。
跳出視窗是使用JOptionPane。
而如果沒有命中，則不造成傷害，一樣用JOptionPane跳出提示視窗。

在getName裡，只要將Skill名稱回傳就好。

最後是亂數選取兩個角色作為開始的角色，
一開始先創一個陣列存放所有種類的角色(三種)，
然後用跟之前作業相同的方法，從三個數字中亂數選兩個不重複的數字，
再將那兩個選到的角色給charaList就好了。
因此最後總共會有六種開始遊戲的可能(3*2)。