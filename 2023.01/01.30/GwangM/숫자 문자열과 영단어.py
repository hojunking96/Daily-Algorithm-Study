def solution(s):
    answer = ''
    le=len(s)
    i=0
    while i<le:
        if '0'<=s[i]<='9':
            answer+=s[i]
        elif s[i]=='z':
            answer+='0'
            i+=3
        elif s[i]=='o':
            answer+='1'
            i+=2
        elif s[i]=='t':
            if s[i+1]=='w':
                answer+='2'
                i+=2
            else:
                answer+='3'
                i+=4
        elif s[i]=='f':
            if s[i+1]=='o':
                answer+='4'
                i+=3
            else:
                answer+='5'
                i+=3
        elif s[i]=='s':
            if s[i+1]=='i':
                answer+='6'
                i+=2
            else:
                answer+='7'
                i+=4
        elif s[i]=='e':
            answer+='8'
            i+=4
        else:
            answer+='9'
            i+=3
        i+=1
    
    return int(answer)
  
#s=input()

#print(solution(s))