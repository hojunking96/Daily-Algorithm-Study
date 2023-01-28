def solution(storey):
    if storey<10:
        return min(storey,(11-storey))
    else:
        end = int(str(storey)[-1])
        storey=storey//10
        return min(solution(storey+1)+10-end,solution(storey)+end)