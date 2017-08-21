# warble-rest-api
> :musical_score: :satellite: A simple Restful HTTP interface for the Warble library
---

## Usage

Run the server

```
lein ring server
```

Then `POST` to `/track` to validate and parse your Warble tracks

```sh
curl -H "Content-Type: text/plain" -X POST -d ":A = [1 -> Scale('C2 Major')] \!Play :A" http://localhost:3000/track
```

That's it :sparkles:

## License

Copyright © 2017 MadHax, LLC

MIT
