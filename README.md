# bach-rest-api
> :musical_score: :satellite: A simple Restful HTTP interface for the bach library
---

## Summary

`bach` is a notation for representing musical tracks with a focus on human readability.

You can find detailed information on the `bach` notation by visiting the [repository home page](https://github.com/slurmulon/bach).

This module simply wraps the core `bach` module with a thin RESTful interface.

## Usage

Run the server

```
lein ring server
```

Then `POST` to `/track` to validate and parse your bach tracks

```sh
curl -H "Content-Type: text/plain" -X POST -d "@/absolute/path/to/bach/file.bach" http://localhost:3000/track
```

That's it :sparkles:

## License

Copyright © 2017 MadHax, LLC

MIT
