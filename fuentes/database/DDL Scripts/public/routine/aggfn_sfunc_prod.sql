create or replace function public.aggfn_sfunc_prod(_agg_state numeric, _current_value numeric) returns numeric
    immutable
    language plpgsql
as
$$
begin
  return _agg_state * _current_value;
end;
$$;

alter function public.aggfn_sfunc_prod(numeric, numeric) owner to postgres;

