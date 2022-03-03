1.fork репозитория KotlinAsFirst2020
2.git init
3.git clone <Url своего KotlinAsFirst2020>
4.cd KotlinAsFirst2020 -переход в папку проекта
5.git remote add -f upstream-my <Url своего KotlinAsFirst2021> -
6.git remote -v -проверка, всё ли правильно добавилось
7.git branch backport -создание новой ветки
8.git checkout backport -переход в ветку backport
9.git cherry-pick -Xours коммит до первого своего..свой последний коммит
(с указанием на приоритетные данные -Xours во избежание конфликтов)
10.gitk -проверка
11.git checkout master
В качестве партнёра - Бойкова Ульяна
12.git barnch backport1
13.git remote add -f upstream-theirs <Url KotlinAsFirst2021 партнёра>
14.git remote -v
15.git checkout backport1
16.git cherry-pick -Xtheirs коммит до первого коммита партнёра..последний коммит партнёра
17.git checkout master
18.git merge backport
19.git merge backport1 -Xtheirs -у партнёра приоритетные изменения
20.gitk
21.git add "howto.md"
22.git commit -m "file howto.md"
23.git add "remotes.txt"
24.git commit -m "file remotes.txt"
25.git push
