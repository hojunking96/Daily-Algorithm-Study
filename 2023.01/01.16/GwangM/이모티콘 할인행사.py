def solve(users,emoticons, list, per, index):
    le=len(per)
    for i in range(1,5):
        per[index]=i*0.1
        if index<le-1:
            solve(users,emoticons,list,per,index+1)
        else:
            tempBuy=0
            tempPlus=0
            for j in users:
                userEmo=0 #이모티콘 구매금액, 이것이 기준 이상이면 플러스 가입
                for k in range(le):
                    if per[k]>=(j[0]*0.01):
                        userEmo+=(1-per[k])*emoticons[k]
                if userEmo>=j[1]:
                    tempPlus+=1
                else:
                    tempBuy+=userEmo
            #모두 방문하면 list[1]와 list[0] 비교
            if tempPlus>list[0]:
                list[0]=tempPlus
                list[1]=tempBuy
            elif tempPlus==list[0] and tempBuy>list[1]:
                list[1]=tempBuy

def solution(users, emoticons):
    per=emoticons[:]
    list=[0,0]
    index=0
    solve(users, emoticons, list, per,index)
    answer = [list[0],list[1]]
    return answer