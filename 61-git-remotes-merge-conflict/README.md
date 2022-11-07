# Esercizio di risoluzione di un merge conflict

**Il tempo massimo in laboratorio per questo esercizio è di _20 minuti_.
Se superato, sospendere l'esercizio e riprenderlo per ultimo!**

Si visiti https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.
Questo repository contiene due branch: `master` e `feature`

Per ognuna delle seguenti istruzioni, si annoti l'output ottenuto.
Prima di eseguire ogni operazione sul worktree o sul repository,
si verifichi lo stato del repository con `git status`.

1. Si cloni localmente il repository
```
git clone https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git
Cloning into 'OOP-git-merge-conflict-test'...
remote: Enumerating objects: 12, done.
remote: Counting objects: 100% (4/4), done.
remote: Compressing objects: 100% (3/3), done.
remote: Total 12 (delta 1), reused 1 (delta 1), pack-reused 8
Receiving objects: 100% (12/12), done.
Resolving deltas: 100% (2/2), done.
```
2. Ci si assicuri di avere localmente entrambi i branch remoti
```
git checkout feature
Switched to a new branch 'feature'
branch 'feature' set up to track 'origin/feature'.
```
```
git branch -v
* feature bed943f Print author information
  master  8e0f29c Change HelloWorld to print the number of available processors
```
3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master`   e da qui si esegua il merge di `feature`
```
Auto-merging HelloWorld.java
CONFLICT (content): Merge conflict in HelloWorld.java
Automatic merge failed; fix conflicts and then commit the result.
```
4. Si noti che viene generato un **merge conflict**!
5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili
     (funzionalità presente su `master`)
     che il nome dell'autore del file
     (funzionalità presente su `feature`)
```
$ git add .

STUDENTI+dario.bekic@lab22-07-04 MINGW64 ~/Desktop/ex61/OOP-git-merge-conflict-test (master|MERGING)
$ git commit -m "Merged feature into master"
[master 8282a4e] Merged feature into master

STUDENTI+dario.bekic@lab22-07-04 MINGW64 ~/Desktop/ex61/OOP-git-merge-conflict-test (master)
$ git log
commit 8282a4ee553db33cf72d63eacc645db6db3a9be0 (HEAD -> master)
Merge: 8e0f29c bed943f
Author: dario <dario.bekic@studio.unibo.it>
Date:   Mon Oct 24 11:07:13 2022 +0200

    Merged feature into master

```
6. Si crei un nuovo repository nel proprio github personale
7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote
```
$ git remote add repodaeliminare https://github.com/darico-code/daeliminare.git

STUDENTI+dario.bekic@lab22-07-04 MINGW64 ~/Desktop/ex61/OOP-git-merge-conflict-test (master)
$ git remote -v
origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git (fetch)
origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git (push)
repodaeliminare https://github.com/darico-code/daeliminare.git (fetch)
repodaeliminare https://github.com/darico-code/daeliminare.git (push)
```
8. Si faccia push del branch `master` sul proprio repository
```
$ git push repodaeliminare
Enumerating objects: 18, done.
Counting objects: 100% (18/18), done.
Delta compression using up to 12 threads
Compressing objects: 100% (14/14), done.
Writing objects: 100% (18/18), 1.86 KiB | 317.00 KiB/s, done.
Total 18 (delta 5), reused 10 (delta 2), pack-reused 0
remote: Resolving deltas: 100% (5/5), done.
To https://github.com/darico-code/daeliminare.git
 * [new branch]      master -> master
```
9. Si setti il branch remoto `master` del nuovo repository come *upstream* per il proprio branch `master` locale
```
$ git branch --set-upstream-to repodaeliminare/master
branch 'master' set up to track 'repodaeliminare/master'.
```