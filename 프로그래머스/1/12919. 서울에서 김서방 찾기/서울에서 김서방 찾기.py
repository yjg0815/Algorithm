def solution(seoul):
    answer = '김서방은 x에 있다'
    x = str(seoul.index('Kim'))
    answer = answer.replace('x', x)
    return answer