:- use_module(library(lists)).

multiple_of_3_or_5(X) :-
    0 is X mod 5
  ; 0 is X mod 3.

% All numbers between N and M that satisfy P
between_if(M, M, _, []).
between_if(N, M, P, Result):-
    N < M,
    N1 is N + 1,
    between_if(N1, M, P, R),
    prepend_if(P, N, R, Result).

% If N satisfies P then prepend N to L, else just return L
prepend_if(P, N, L, Result) :-
    call(P, N) ->
        Result = [N | L]
    ;   Result = L.

result(Result) :-
    between_if(0, 1000, multiple_of_3_or_5, L),
    sum_list(L, Result),!.
