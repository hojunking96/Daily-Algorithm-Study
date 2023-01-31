def grade(correct_score: int) -> int:
    return 6 if correct_score < 2 else 7-correct_score


def solution(lottos, win_nums):
    answer = []
    
    correct_score = 0
    blackbox_score = 0
    
    for lotto_num in lottos:
        if lotto_num == 0:
            blackbox_score += 1 
            continue
        
        for win_num in win_nums:
            if lotto_num == win_num: 
                correct_score += 1 
                break
                
    answer.append(grade(correct_score+blackbox_score))
    answer.append(grade(correct_score))

    
    return answer
