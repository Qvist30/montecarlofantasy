package montecarlofantasy;

import java.util.Comparator;

public class TeamComparator implements Comparator<Team> {

	@Override
	public int compare(Team teamA, Team teamB) {
		if (teamB.getTotalWins() > teamA.getTotalWins()) {
			return 1;
		} else if (teamA.getTotalWins() > teamB.getTotalWins()) {
			return -1;
		} else {
			return 0;
		}
	}

	public int handleTiebreakers(Team teamA, Team teamB) {
//		if(teamA.get)
		return getError(teamA, teamB);
	}

	private int handleJeffTiebreakers(Team teamA, Team teamB) {
		if (teamB == MonteCarloRun.tony || teamB == MonteCarloRun.ross) {
			return 1;
		}
		return getError(teamA, teamB);
	}

	private int handleAaronTiebreakers(Team teamA, Team teamB) {
		if (MonteCarloRun.aaron.getTotalWins() == MonteCarloRun.jackie.getTotalWins()
				&& MonteCarloRun.aaron.getTotalWins() == MonteCarloRun.tyler.getTotalWins()
				&& MonteCarloRun.aaron.getTotalWins() == MonteCarloRun.brad.getTotalWins()) {
			if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()) {
				if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.tyler || teamB == MonteCarloRun.brad) {
					return -1;
				}
			} else if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()) {
				if (teamB == MonteCarloRun.jackie) {
					return 1;
				} else {
					return getAaronBradTylerTiebreaker(teamA, teamB);
				}
			} else if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()) {
				if (teamB == MonteCarloRun.tyler) {
					return 1;
				} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
						&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()) {
					if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.brad) {
						return -1;
					} else if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
							&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()) {
						if (teamB == MonteCarloRun.jackie) {
							return 1;
						} else if (teamB == MonteCarloRun.brad) {
							return getPointsTiebreaker(teamA, teamB);
						}
					} else {
						if (teamB == MonteCarloRun.brad) {
							return 1;
						} else if (teamB == MonteCarloRun.jackie) {
							return 1;
						}
					}
				}
			} else if (MonteCarloRun.aaron.getTotalWins() == MonteCarloRun.jackie.getTotalWins()
					&& MonteCarloRun.aaron.getTotalWins() == MonteCarloRun.seth.getTotalWins()
					&& MonteCarloRun.aaron.getTotalWins() == MonteCarloRun.tyler.getTotalWins()) {
				if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
						&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
						&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
					if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.seth || teamB == MonteCarloRun.tyler) {
						return -1;
					}
				} else {
					if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
							&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
							&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
						if (teamB == MonteCarloRun.jackie) {
							return 1;
						} else {
							return getAaronSethTylerTiebreaker(teamA, teamB);
						}
					} else if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
							&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
							&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
						if (teamB == MonteCarloRun.seth) {
							return 1;
						} else {
							if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
									&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler
											.getProjectedPoints()) {
								if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.tyler) {
									return -1;
								}
							} else if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.aaron
									.getProjectedPoints()
									&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.tyler
											.getProjectedPoints()) {
								if (teamB == MonteCarloRun.jackie) {
									return 1;
								} else if (teamB == MonteCarloRun.tyler) {
									return -1;
								}
							} else {
								if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.tyler) {
									return 1;
								}
							}
						}
					} else if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
							&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
							&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
						if (teamB == MonteCarloRun.tyler) {
							return 1;
						} else {
							if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
									&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.seth
											.getProjectedPoints()) {
								if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.seth) {
									return -1;
								}
							} else {
								if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.seth) {
									return 1;
								}
							}
						}
					}
				}
			} else if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.brad) {
					return 1;
				} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
						&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
					if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.tyler) {
						return -1;
					} else if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
							&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
						if (teamB == MonteCarloRun.jackie) {
							return 1;
						} else if (teamB == MonteCarloRun.tyler) {
							return -1;
						}
					} else {
						if (teamB == MonteCarloRun.tyler) {
							return 1;
						} else if (teamB == MonteCarloRun.jackie) {
							return 1;
						}
					}
				}
			}
		}  else if (MonteCarloRun.aaron.getTotalWins() == MonteCarloRun.jackie.getTotalWins()
				&& MonteCarloRun.aaron.getTotalWins() == MonteCarloRun.seth.getTotalWins()
				&& MonteCarloRun.aaron.getTotalWins() == MonteCarloRun.tyler.getTotalWins()) {
			if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.seth || teamB == MonteCarloRun.tyler) {
					return -1;
				}
			} else {
				if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
						&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
						&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
					if (teamB == MonteCarloRun.jackie) {
						return 1;
					} else {
						return getAaronSethTylerTiebreaker(teamA, teamB);
					}
				} else if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
						&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
						&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
					if (teamB == MonteCarloRun.seth) {
						return 1;
					} else {
						if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
								&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler
										.getProjectedPoints()) {
							if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.tyler) {
								return -1;
							}
						} else if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.aaron
								.getProjectedPoints()
								&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.tyler
										.getProjectedPoints()) {
							if (teamB == MonteCarloRun.jackie) {
								return 1;
							} else if (teamB == MonteCarloRun.tyler) {
								return -1;
							}
						} else {
							if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.tyler) {
								return 1;
							}
						}
					}
				} else if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
						&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
						&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
					if (teamB == MonteCarloRun.tyler) {
						return 1;
					} else {
						if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
								&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.seth
										.getProjectedPoints()) {
							if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.seth) {
								return -1;
							}
						} else {
							if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.seth) {
								return 1;
							}
						}
					}
				}
			}
		}else if (MonteCarloRun.aaron.getTotalWins() == MonteCarloRun.brad.getTotalWins()
				&& MonteCarloRun.aaron.getTotalWins() == MonteCarloRun.tyler.getTotalWins()
				&& MonteCarloRun.aaron.getTotalWins() == MonteCarloRun.seth.getTotalWins()) {
			if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.tyler || teamB == MonteCarloRun.seth) {
					return -1;
				}
			} else if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.brad) {
					return 1;
				} else {
					return getAaronSethTylerTiebreaker(teamA, teamB);
				}
			} else if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.tyler) {
					return 1;
				} else {
					if (teamB == MonteCarloRun.brad) {
						return 1;
					} else if (teamB == MonteCarloRun.seth) {
						return -1;
					}
				}
			} else if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.seth) {
					return 1;
				} else {
					return getAaronBradTylerTiebreaker(teamA, teamB);
				}
			}
		} else if (MonteCarloRun.aaron.getTotalWins() == MonteCarloRun.jason.getTotalWins()
				&& MonteCarloRun.aaron.getTotalWins() == MonteCarloRun.tyler.getTotalWins()) {
			if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.jason || teamB == MonteCarloRun.tyler) {
					return -1;
				}
			} else {
				if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
						&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
					if (teamB == MonteCarloRun.jason) {
						return 1;
					} else if (teamB == MonteCarloRun.tyler) {
						return -1;
					}
				} else if (teamB == MonteCarloRun.jason || teamB == MonteCarloRun.tyler) {
					return 1;
				}
			}
		} else if (MonteCarloRun.aaron.getTotalWins() == MonteCarloRun.brad.getTotalWins()
				&& MonteCarloRun.aaron.getTotalWins() == MonteCarloRun.jason.getTotalWins()) {
			if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
				if (teamB == MonteCarloRun.brad || teamB == MonteCarloRun.jason) {
					return -1;
				}
			} else if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
				if (teamB == MonteCarloRun.jason) {
					return 1;
				} else if (teamB == MonteCarloRun.brad) {
					if (MonteCarloRun.billyOverAaron) {
						return getPointsTiebreaker(teamA, teamB);
					} else {
						return -1;
					}
				}
			} else {
				if (teamB == MonteCarloRun.brad || teamB == MonteCarloRun.jason) {
					return 1;
				}
			}
		} else if (MonteCarloRun.aaron.getTotalWins() == MonteCarloRun.brad.getTotalWins()
				&& MonteCarloRun.aaron.getTotalWins() == MonteCarloRun.tyler.getTotalWins()) {
			return getAaronBradTylerTiebreaker(teamA, teamB);
		}
		if (teamB == MonteCarloRun.seth) {
			return 1;
		}
		if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.jason) {
			return 1;
		}
		if (teamB == MonteCarloRun.tyler) {
			return -1;
		}
		if (teamB == MonteCarloRun.brad) {
			if (MonteCarloRun.billyOverAaron) {
				return getPointsTiebreaker(teamA, teamB);
			} else {
				return -1;
			}
		}
		if (teamB == MonteCarloRun.nick) {
			return getPointsTiebreaker(teamA, teamB);
		}
		return getError(teamA, teamB);
	}

	private int getAaronSethTylerTiebreaker(Team teamA, Team teamB) {
		if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
				&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
			if (teamB == MonteCarloRun.seth || teamB == MonteCarloRun.tyler) {
				return -1;
			}
		} else if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
				&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
			if (teamB == MonteCarloRun.seth) {
				return 1;
			} else if (teamB == MonteCarloRun.tyler) {
				return -1;
			}
		} else {
			if (teamB == MonteCarloRun.seth || teamB == MonteCarloRun.tyler) {
				return 1;
			}
		}
		return getError(teamA, teamB);
	}

	private int getAaronBradTylerTiebreaker(Team teamA, Team teamB) {
		if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
				&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()) {
			if (teamB == MonteCarloRun.tyler || teamB == MonteCarloRun.brad) {
				return -1;
			}
		} else if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
				&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()) {
			if (teamB == MonteCarloRun.tyler) {
				return 1;
			} else if (teamB == MonteCarloRun.brad) {
				return getPointsTiebreaker(teamA, teamB);
			}
		} else {
			if (teamB == MonteCarloRun.brad) {
				return 1;
			} else if (teamB == MonteCarloRun.tyler) {
				return -1;
			}
		}
		return getError(teamA, teamB);
	}

	private int handleNickTiebreakers(Team teamA, Team teamB) {
		if (MonteCarloRun.nick.getTotalWins() == MonteCarloRun.jackie.getTotalWins()
				&& MonteCarloRun.nick.getTotalWins() == MonteCarloRun.aaron.getTotalWins()) {
			if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.aaron) {
				return getPointsTiebreaker(teamA, teamB);
			}
		} else if (teamB == MonteCarloRun.joe || teamB == MonteCarloRun.tom) {
			return 1;
		} else if (teamB == MonteCarloRun.jackie) {
			return getPointsTiebreaker(teamA, teamB);
		}
		return getError(teamA, teamB);
	}

	private int handleTonyTiebreakers(Team teamA, Team teamB) {
		if (MonteCarloRun.tony.getTotalWins() == MonteCarloRun.jason.getTotalWins()
				&& MonteCarloRun.tony.getTotalWins() == MonteCarloRun.ross.getTotalWins()) {
			if (MonteCarloRun.tony.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.tony.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()) {
				if (teamB == MonteCarloRun.jason || teamB == MonteCarloRun.ross) {
					return -1;
				}
			} else if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.tony.getProjectedPoints()
					&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()) {
				if (teamB == MonteCarloRun.jason || teamB == MonteCarloRun.ross) {
					return 1;
				}
			} else {
				if (teamB == MonteCarloRun.jason || teamB == MonteCarloRun.ross) {
					return 1;
				}
			}
		} else if (MonteCarloRun.tony.getTotalWins() == MonteCarloRun.jeff.getTotalWins()
				&& MonteCarloRun.tony.getTotalWins() == MonteCarloRun.ross.getTotalWins()) {
			if (teamB == MonteCarloRun.ross) {
				return 1;
			} else if (teamB == MonteCarloRun.jeff) {
				return -1;
			}
		} else if (MonteCarloRun.tony.getTotalWins() == MonteCarloRun.jeff.getTotalWins()) {
			if (teamB == MonteCarloRun.jeff) {
				return -1;
			}
		} else if (MonteCarloRun.tony.getTotalWins() == MonteCarloRun.ross.getTotalWins()) {
			if (teamB == MonteCarloRun.ross) {
				return 1;
			}
		} else if (teamB == MonteCarloRun.jason) {
			return 1;
		}
		return getError(teamA, teamB);
	}

	private int handleRossTiebreakers(Team teamA, Team teamB) {
		if (MonteCarloRun.ross.getTotalWins() == MonteCarloRun.seth.getTotalWins()
				&& MonteCarloRun.ross.getTotalWins() == MonteCarloRun.tyler.getTotalWins()
				&& MonteCarloRun.ross.getTotalWins() == MonteCarloRun.jason.getTotalWins()) {
			if (MonteCarloRun.ross.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
					&& MonteCarloRun.ross.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.ross.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
				if (teamB == MonteCarloRun.seth || teamB == MonteCarloRun.tyler || teamB == MonteCarloRun.jason) {
					return -1;
				}
			} else if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
				if (teamB == MonteCarloRun.seth) {
					return 1;
				} else {
					return getRossJasonTylerTiebreaker(teamA, teamB);
				}

			} else if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
				if (teamB == MonteCarloRun.tyler) {
					return 1;
				} else if (MonteCarloRun.ross.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
						&& MonteCarloRun.ross.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
					if (teamB == MonteCarloRun.seth || teamB == MonteCarloRun.jason) {
						return -1;
					} else {
						return getRossJasonSethTiebreaker(teamA, teamB);
					}
				}
			} else if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()
					&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
					&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.jason) {
					return 1;
				} else {
					if (MonteCarloRun.ross.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
							&& MonteCarloRun.ross.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
						if (teamB == MonteCarloRun.seth || teamB == MonteCarloRun.tyler) {
							return -1;
						} else if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()
								&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
							if (teamB == MonteCarloRun.seth) {
								return 1;
							} else if (teamB == MonteCarloRun.tyler) {
								return -1;
							}
						} else {
							if (teamB == MonteCarloRun.tyler) {
								return 1;
							} else if (teamB == MonteCarloRun.seth) {
								return getPointsTiebreaker(teamA, teamB);
							}
						}
					}
				}
			}
		} else if (MonteCarloRun.ross.getTotalWins() == MonteCarloRun.jason.getTotalWins()
				&& MonteCarloRun.ross.getTotalWins() == MonteCarloRun.tyler.getTotalWins()) {
			return getRossJasonTylerTiebreaker(teamA, teamB);
		} else if (MonteCarloRun.ross.getTotalWins() == MonteCarloRun.jason.getTotalWins()
				&& MonteCarloRun.ross.getTotalWins() == MonteCarloRun.seth.getTotalWins()) {
			return getRossJasonSethTiebreaker(teamA, teamB);
		}
		if (MonteCarloRun.ross.getTotalWins() == MonteCarloRun.jason.getTotalWins()
				&& MonteCarloRun.ross.getTotalWins() == MonteCarloRun.tony.getTotalWins()) {
			if (MonteCarloRun.ross.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.ross.getProjectedPoints() > MonteCarloRun.tony.getProjectedPoints()) {
				if (teamB == MonteCarloRun.jason || teamB == MonteCarloRun.tony) {
					return -1;
				}
			} else if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()
					&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.tony.getProjectedPoints()) {
				if (teamB == MonteCarloRun.jason) {
					return 1;
				} else if (teamB == MonteCarloRun.tony) {
					return -1;
				}
			} else {
				if (teamB == MonteCarloRun.tony) {
					return 1;
				} else if (teamB == MonteCarloRun.jason) {
					return getPointsTiebreaker(teamA, teamB);
				}
			}
		}
		if (MonteCarloRun.ross.getTotalWins() == MonteCarloRun.brad.getTotalWins()
				&& MonteCarloRun.ross.getTotalWins() == MonteCarloRun.jason.getTotalWins()) {
			if (MonteCarloRun.ross.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.ross.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
				if (teamB == MonteCarloRun.brad || teamB == MonteCarloRun.jason) {
					return -1;
				}
			} else if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
				if (teamB == MonteCarloRun.brad) {
					return 1;
				} else if (teamB == MonteCarloRun.jason) {
					return getPointsTiebreaker(teamA, teamB);
				}
			} else {
				if (teamB == MonteCarloRun.jason) {
					return 1;
				} else if (teamB == MonteCarloRun.brad) {
					return getPointsTiebreaker(teamA, teamB);
				}
			}
		} else if (MonteCarloRun.ross.getTotalWins() == MonteCarloRun.jeff.getTotalWins()
				&& MonteCarloRun.ross.getTotalWins() == MonteCarloRun.tony.getTotalWins()) {
			if (teamB == MonteCarloRun.jeff || teamB == MonteCarloRun.tony) {
				return -1;
			}
		} else if (MonteCarloRun.ross.getTotalWins() == MonteCarloRun.jason.getTotalWins()) {
			if (teamB == MonteCarloRun.jason) {
				return getPointsTiebreaker(teamA, teamB);
			}
		} else if (teamB == MonteCarloRun.seth || teamB == MonteCarloRun.brad) {
			return getPointsTiebreaker(teamA, teamB);
		} else if (teamB == MonteCarloRun.tony || teamB == MonteCarloRun.tyler || teamB == MonteCarloRun.jeff) {
			return -1;
		}
		return getError(teamA, teamB);
	}

	private int getRossJasonTylerTiebreaker(Team teamA, Team teamB) {
		if (MonteCarloRun.ross.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
				&& MonteCarloRun.ross.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
			if (teamB == MonteCarloRun.tyler || teamB == MonteCarloRun.jason) {
				return -1;
			}
		} else if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()
				&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
			if (teamB == MonteCarloRun.tyler) {
				return 1;
			} else if (teamB == MonteCarloRun.jason) {
				return getPointsTiebreaker(teamA, teamB);
			}
		} else {
			if (teamB == MonteCarloRun.jason) {
				return 1;
			} else if (teamB == MonteCarloRun.tyler) {
				return -1;
			}
		}
		return getError(teamA, teamB);
	}

	private int getError(Team teamA, Team teamB) {
		try {
			throw new Exception("Error");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(teamA.getName() + " is equal to " + teamB.getName());
		return 0;
	}

	private int getRossJasonSethTiebreaker(Team teamA, Team teamB) {
		if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()
				&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
			if (teamB == MonteCarloRun.seth) {
				return 1;
			} else if (teamB == MonteCarloRun.jason) {
				return getPointsTiebreaker(teamA, teamB);
			}
		} else {
			if (teamB == MonteCarloRun.jason) {
				return 1;
			} else if (teamB == MonteCarloRun.tyler) {
				return getPointsTiebreaker(teamA, teamB);
			}
		}
		return getError(teamA, teamB);
	}

	private int handleJasonTiebreakers(Team teamA, Team teamB) {
		if (MonteCarloRun.jason.getTotalWins() == MonteCarloRun.aaron.getTotalWins()
				&& MonteCarloRun.jason.getTotalWins() == MonteCarloRun.brad.getTotalWins()
				&& MonteCarloRun.jason.getTotalWins() == MonteCarloRun.seth.getTotalWins()) {
			if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.brad || teamB == MonteCarloRun.seth) {
					return -1;
				}
			} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.aaron) {
					return 1;
				} else {
					return getJasonBradSethTIebreaker(teamA, teamB);
				}
			} else if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.brad) {
					return 1;
				} else {
					return getJasonAaronSethTiebreaker(teamA, teamB);
				}
			} else if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()) {
				if (teamB == MonteCarloRun.seth) {
					return 1;
				} else {
					return getJasonAaronBradTiebreaker(teamA, teamB);
				}
			}
		}
		if (MonteCarloRun.jason.getTotalWins() == MonteCarloRun.brad.getTotalWins()
				&& MonteCarloRun.jason.getTotalWins() == MonteCarloRun.seth.getTotalWins()
				&& MonteCarloRun.jason.getTotalWins() == MonteCarloRun.tyler.getTotalWins()) {
			if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
					&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.brad || teamB == MonteCarloRun.seth || teamB == MonteCarloRun.tyler) {
					return -1;
				}
			} else if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.brad) {
					return 1;
				} else {
					return getJasonSethTylerTiebreaker(teamA, teamB);
				}
			} else if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.seth) {
					return 1;
				} else {
					return getJasonBradTylerTiebreaker(teamA, teamB);
				}
			} else if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.tyler) {
					return 1;
				} else {
					return getJasonBradSethTIebreaker(teamA, teamB);
				}
			}
		}
		if (MonteCarloRun.jason.getTotalWins() == MonteCarloRun.aaron.getTotalWins()
				&& MonteCarloRun.jason.getTotalWins() == MonteCarloRun.seth.getTotalWins()
				&& MonteCarloRun.jason.getTotalWins() == MonteCarloRun.tyler.getTotalWins()) {
			if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
					&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.seth || teamB == MonteCarloRun.tyler) {
					return -1;
				}
			} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.aaron) {
					return 1;
				} else {
					return getJasonSethTylerTiebreaker(teamA, teamB);
				}
			} else if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.seth) {
					return 1;
				} else {
					return getJasonAaronTylerTiebreaker(teamA, teamB);
				}
			} else if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.tyler) {
					return 1;
				} else {
					return getJasonAaronSethTiebreaker(teamA, teamB);
				}
			}
		} else if (MonteCarloRun.jason.getTotalWins() == MonteCarloRun.aaron.getTotalWins()
				&& MonteCarloRun.jason.getTotalWins() == MonteCarloRun.brad.getTotalWins()
				&& MonteCarloRun.jason.getTotalWins() == MonteCarloRun.tyler.getTotalWins()) {
			if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.brad || teamB == MonteCarloRun.tyler) {
					return -1;
				}
			} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.aaron) {
					return 1;
				} else {
					return getJasonBradTylerTiebreaker(teamA, teamB);
				}
			} else if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.brad) {
					return 1;
				} else {
					return getJasonAaronTylerTiebreaker(teamA, teamB);
				}
			} else if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()) {
				if (teamB == MonteCarloRun.tyler) {
					return 1;
				} else {
					return getJasonAaronBradTiebreaker(teamA, teamB);
				}
			}
		} else if (MonteCarloRun.jason.getTotalWins() == MonteCarloRun.aaron.getTotalWins()
				&& MonteCarloRun.jason.getTotalWins() == MonteCarloRun.tyler.getTotalWins()) {
			return getJasonAaronTylerTiebreaker(teamA, teamB);
		} else if (MonteCarloRun.jason.getTotalWins() == MonteCarloRun.ross.getTotalWins()
				&& MonteCarloRun.jason.getTotalWins() == MonteCarloRun.tony.getTotalWins()) {
			if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()
					&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.tony.getProjectedPoints()) {
				if (teamB == MonteCarloRun.ross || teamB == MonteCarloRun.tony) {
					return -1;
				}
			} else if (MonteCarloRun.ross.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.ross.getProjectedPoints() > MonteCarloRun.tony.getProjectedPoints()) {
				if (teamB == MonteCarloRun.ross) {
					return 1;
				} else if (teamB == MonteCarloRun.tony) {
					return -1;
				}
			} else {
				if (teamB == MonteCarloRun.ross || teamB == MonteCarloRun.tony) {
					return 1;
				}
			}
		} else if (MonteCarloRun.jason.getTotalWins() == MonteCarloRun.seth.getTotalWins()
				&& MonteCarloRun.jason.getTotalWins() == MonteCarloRun.tyler.getTotalWins()) {
			return getJasonSethTylerTiebreaker(teamA, teamB);
		} else if (MonteCarloRun.jason.getTotalWins() == MonteCarloRun.brad.getTotalWins()
				&& MonteCarloRun.jason.getTotalWins() == MonteCarloRun.seth.getTotalWins()) {
			return getJasonBradSethTIebreaker(teamA, teamB);
		} else if (MonteCarloRun.jason.getTotalWins() == MonteCarloRun.aaron.getTotalWins()
				&& MonteCarloRun.jason.getTotalWins() == MonteCarloRun.seth.getTotalWins()) {
			return getJasonAaronSethTiebreaker(teamA, teamB);
		} else if (MonteCarloRun.jason.getTotalWins() == MonteCarloRun.brad.getTotalWins()
				&& MonteCarloRun.jason.getTotalWins() == MonteCarloRun.tyler.getTotalWins()) {
			return getJasonBradTylerTiebreaker(teamA, teamB);
		} else if (MonteCarloRun.jason.getTotalWins() == MonteCarloRun.seth.getTotalWins()) {
			return getJasonSethTiebreaker(teamA, teamB);
		} else if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.brad) {
			return -1;
		} else if (teamB == MonteCarloRun.tyler || teamB == MonteCarloRun.ross) {
			return getPointsTiebreaker(teamA, teamB);
		}
		return getError(teamA, teamB);
	}

	private int getJasonAaronBradTiebreaker(Team teamA, Team teamB) {
		if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
				&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()) {
			if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.brad) {
				return -1;
			}
		} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
				&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()) {
			if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.brad) {
				return 1;
			}
		} else {
			if (teamB == MonteCarloRun.brad) {
				return 1;
			} else if (teamB == MonteCarloRun.aaron) {
				return -1;
			}
		}
		return getError(teamA, teamB);
	}

	private int getJasonAaronSethTiebreaker(Team teamA, Team teamB) {
		if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
				&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
			if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.seth) {
				return -1;
			}
		} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
				&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
			if (teamB == MonteCarloRun.aaron) {
				return 1;
			} else
				return getJasonSethTiebreaker(teamA, teamB);
		} else {
			if (teamB == MonteCarloRun.seth) {
				return 1;
			} else if (teamB == MonteCarloRun.aaron) {
				return -1;
			}
		}
		return getError(teamA, teamB);
	}

	private int getJasonAaronTylerTiebreaker(Team teamA, Team teamB) {
		if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
				&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
			if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.tyler) {
				return -1;
			}
		} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
				&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
			if (teamB == MonteCarloRun.aaron) {
				return 1;
			} else if (teamB == MonteCarloRun.tyler) {
				return getPointsTiebreaker(teamA, teamB);
			}
		} else {
			if (teamB == MonteCarloRun.tyler) {
				return 1;
			} else if (teamB == MonteCarloRun.aaron) {
				return -1;
			}
		}
		return getError(teamA, teamB);
	}

	private int getJasonBradSethTIebreaker(Team teamA, Team teamB) {
		if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
				&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
			if (teamB == MonteCarloRun.brad || teamB == MonteCarloRun.seth) {
				return -1;
			}
		} else if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
				&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
			if (teamB == MonteCarloRun.brad) {
				return 1;
			} else
				return getJasonSethTiebreaker(teamA, teamB);
		} else {
			if (teamB == MonteCarloRun.seth || teamB == MonteCarloRun.brad) {
				return 1;
			}
		}
		return getError(teamA, teamB);
	}

	private int getJasonBradTylerTiebreaker(Team teamA, Team teamB) {
		if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
				&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
			if (teamB == MonteCarloRun.brad || teamB == MonteCarloRun.tyler) {
				return -1;
			}
		} else if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
				&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
			if (teamB == MonteCarloRun.brad) {
				return 1;
			} else if (teamB == MonteCarloRun.tyler) {
				getPointsTiebreaker(teamA, teamB);
			}
		} else {
			if (teamB == MonteCarloRun.tyler || teamB == MonteCarloRun.brad) {
				return 1;
			}
		}
		return getError(teamA, teamB);
	}

	private int getJasonSethTylerTiebreaker(Team teamA, Team teamB) {
		if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
				&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
			if (teamB == MonteCarloRun.seth || teamB == MonteCarloRun.tyler) {
				return -1;
			}
		} else if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
				&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
			if (teamB == MonteCarloRun.seth) {
				return 1;
			} else if (teamB == MonteCarloRun.tyler) {
				return getPointsTiebreaker(teamA, teamB);
			}
		} else {
			return getJasonSethTiebreaker(teamA, teamB);
		}
		return getError(teamA, teamB);
	}

	private int getJasonSethTiebreaker(Team teamA, Team teamB) {
		if (teamB == MonteCarloRun.seth) {
			return getPointsTiebreaker(teamA, teamB);
		}
		return getError(teamA, teamB);
	}

	private int handleJoeTiebreakers(Team teamA, Team teamB) {
		if (MonteCarloRun.joe.getTotalWins() == MonteCarloRun.jackie.getTotalWins()
				|| MonteCarloRun.joe.getTotalWins() == MonteCarloRun.nick.getTotalWins()) {
			if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.nick.getProjectedPoints()) {
				if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.nick) {
					return 1;
				}
			} else {
				if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.nick) {
					return -1;
				}
			}
		} else if (MonteCarloRun.joe.getTotalWins() == MonteCarloRun.nick.getTotalWins()) {
			if (teamB == MonteCarloRun.nick) {
				return -1;
			}
		} else if (teamB == MonteCarloRun.tom) {
			return getPointsTiebreaker(teamA, teamB);
		} else if (teamB == MonteCarloRun.jackie) {
			return 1;
		}
		return getError(teamA, teamB);
	}

	private int handleTylerTiebreakers(Team teamA, Team teamB) {
		if (MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.seth.getTotalWins()
				&& MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.brad.getTotalWins()
				&& MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.jason.getTotalWins()
				&& MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.ross.getTotalWins()) {
			if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()) {
				if (teamB == MonteCarloRun.seth || teamB == MonteCarloRun.brad || teamB == MonteCarloRun.jason
						|| teamB == MonteCarloRun.ross) {
					return -1;
				}
			} else if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()) {
				if (teamB == MonteCarloRun.seth) {
					return 1;
				} else if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
						&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
						&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()) {
					if (teamB == MonteCarloRun.brad || teamB == MonteCarloRun.jason || teamB == MonteCarloRun.ross) {
						return -1;
					}
				} else if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
						&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
						&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()) {
					if (teamB == MonteCarloRun.brad) {
						return 1;
					} else {
						return getTylerJasonRossTiebreaker(teamA, teamB);
					}
				} else if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
						&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
						&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()) {
					if (teamB == MonteCarloRun.jason) {
						return 1;
					} else {
						return getTylerBradRossTiebreaker(teamA, teamB);
					}
				}

			} else if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()) {
				if (teamB == MonteCarloRun.brad) {
					return 1;
				} else if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
						&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
						&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()) {
					if (teamB == MonteCarloRun.seth || teamB == MonteCarloRun.jason || teamB == MonteCarloRun.ross) {
						return -1;
					}
				} else if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
						&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
						&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()) {
					if (teamB == MonteCarloRun.seth) {
						return 1;
					} else {
						return getTylerJasonRossTiebreaker(teamA, teamB);
					}
				}

			} else if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
					&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()) {
				if (teamB == MonteCarloRun.jason) {
					return 1;
				} else if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
						&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
						&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()) {
					if (teamB == MonteCarloRun.seth || teamB == MonteCarloRun.brad || teamB == MonteCarloRun.ross) {
						return -1;
					}
				} else if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
						&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
						&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()) {
					if (teamB == MonteCarloRun.seth) {
						return 1;
					} else if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
							&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()) {
						if (teamB == MonteCarloRun.ross || teamB == MonteCarloRun.brad) {
							return -1;
						}
					} else if (teamB == MonteCarloRun.ross || teamB == MonteCarloRun.brad) {
						return 1;
					}
				}

			} else if (MonteCarloRun.ross.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.ross.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
					&& MonteCarloRun.ross.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.ross.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
				if (teamB == MonteCarloRun.ross) {
					return 1;
				} else {
					return getTylerBradJasonSethTiebreaker(teamA, teamB);
				}

			}
		} else if (MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.brad.getTotalWins()
				&& MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.jason.getTotalWins()
				&& MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.seth.getTotalWins()) {
			return getTylerBradJasonSethTiebreaker(teamA, teamB);
		} else if (MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.jackie.getTotalWins()
				&& MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.aaron.getTotalWins()
				&& MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.seth.getTotalWins()) {
			if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.seth) {
					return -1;
				}
			} else if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.jackie) {
					return 1;
				} else {
					return getTylerAaronSethTiebreaker(teamA, teamB);
				}
			} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.aaron) {
					return 1;
				} else
					return getTylerJackieSethTiebreaker(teamA, teamB);
			} else if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()) {
				if (teamB == MonteCarloRun.seth) {
					return 1;
				} else if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
						&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()) {
					if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.aaron) {
						return -1;
					}
				} else if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
						&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()) {
					if (teamB == MonteCarloRun.jackie) {
						return 1;
					} else if (teamB == MonteCarloRun.aaron) {
						return 1;
					}
				} else {
					if (teamB == MonteCarloRun.aaron) {
						return 1;
					} else if (teamB == MonteCarloRun.jackie) {
						return -1;
					}
				}
			}
		} else if (MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.jackie.getTotalWins()
				&& MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.aaron.getTotalWins()
				&& MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.seth.getTotalWins()) {
			if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.seth) {
					return -1;
				}
			} else if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.jackie) {
					return 1;
				} else {
					return getTylerAaronSethTiebreaker(teamA, teamB);
				}
			} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.aaron) {
					return 1;
				} else
					return getTylerJackieSethTiebreaker(teamA, teamB);
			} else if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()) {
				if (teamB == MonteCarloRun.seth) {
					return 1;
				} else if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
						&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()) {
					if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.aaron) {
						return -1;
					}
				} else if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
						&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()) {
					if (teamB == MonteCarloRun.jackie) {
						return 1;
					} else if (teamB == MonteCarloRun.aaron) {
						return 1;
					}
				} else {
					if (teamB == MonteCarloRun.aaron) {
						return 1;
					} else if (teamB == MonteCarloRun.jackie) {
						return -1;
					}
				}
			}
		}else if (MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.brad.getTotalWins()
				&& MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.jackie.getTotalWins()
				&& MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.seth.getTotalWins()) {
			if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.brad || teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.seth) {
					return -1;
				}
			} else if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.brad) {
					return 1;
				} else {
					return getTylerJackieSethTiebreaker(teamA, teamB);
				}
			} else if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.jackie) {
					return 1;
				} else {
					return getTylerBradSethTiebreaker(teamA, teamB);
				}
			} else if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()) {
				if (teamB == MonteCarloRun.seth) {
					return 1;
				} else {
					return getTylerBradJackieTiebreaker(teamA, teamB);
				}
			}
		} else if (MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.aaron.getTotalWins()
				&& MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.jason.getTotalWins()
				&& MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.seth.getTotalWins()) {
			if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.jason || teamB == MonteCarloRun.seth) {
					return -1;
				}
			} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.brad) {
					return 1;
				} else {
					return getTylerJasonSethTiebreaker(teamA, teamB);
				}
			} else if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.jason) {
					return 1;
				} else {
					return getTylerAaronSethTiebreaker(teamA, teamB);
				}
			} else if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
				if (teamB == MonteCarloRun.seth) {
					return 1;
				} else {
					return getTylerAaronJasonTiebreaker(teamA, teamB);
				}
			}
		} else if (MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.jason.getTotalWins()
				&& MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.ross.getTotalWins()
				&& MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.seth.getTotalWins()) {
			if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.jason || teamB == MonteCarloRun.ross || teamB == MonteCarloRun.seth) {
					return -1;
				}
			} else if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()
					&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.jason) {
					return 1;
				} else {
					if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()
							&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
						if (teamB == MonteCarloRun.ross || teamB == MonteCarloRun.seth) {
							return -1;
						}
					} else if (MonteCarloRun.ross.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
							&& MonteCarloRun.ross.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
						if (teamB == MonteCarloRun.ross) {
							return 1;
						} else if (teamB == MonteCarloRun.seth) {
							return 1;
						}
					} else {
						if (teamB == MonteCarloRun.ross || teamB == MonteCarloRun.seth) {
							return 1;
						}
					}
				}
			} else if (MonteCarloRun.ross.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.ross.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.ross.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.jackie) {
					return 1;
				} else {
					return getTylerJasonSethTiebreaker(teamA, teamB);
				}
			} else if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()) {
				if (teamB == MonteCarloRun.seth) {
					return 1;
				} else {
					return getTylerJasonRossTiebreaker(teamA, teamB);
				}
			}
		} else if (MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.aaron.getTotalWins()
				&& MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.brad.getTotalWins()
				&& MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.jason.getTotalWins()) {
			if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
				if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.brad || teamB == MonteCarloRun.jason) {
					return -1;
				}
			} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
				if (teamB == MonteCarloRun.aaron) {
					return 1;
				} else {
					return getTylerBradJasonTiebreaker(teamA, teamB);
				}
			} else if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
				if (teamB == MonteCarloRun.brad) {
					return 1;
				} else {
					return getTylerAaronJasonTiebreaker(teamA, teamB);
				}

			} else if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()) {
				if (teamB == MonteCarloRun.seth) {
					return 1;
				} else {
					return getTylerAaronBradTiebreaker(teamA, teamB);
				}
			}
		} else if (MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.aaron.getTotalWins()
				&& MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.brad.getTotalWins()
				&& MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.seth.getTotalWins()) {
			if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.brad || teamB == MonteCarloRun.seth) {
					return -1;
				}
			} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.aaron) {
					return 1;
				} else {
					return getTylerBradSethTiebreaker(teamA, teamB);
				}
			} else if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.brad) {
					return 1;
				} else {
					return getTylerAaronSethTiebreaker(teamA, teamB);
				}

			} else if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()) {
				if (teamB == MonteCarloRun.seth) {
					return 1;
				} else {
					return getTylerAaronBradTiebreaker(teamA, teamB);
				}
			}
		} else if (MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.brad.getTotalWins()
				&& MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.jason.getTotalWins()
				&& MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.ross.getTotalWins()) {
			if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()) {
				if (teamB == MonteCarloRun.brad || teamB == MonteCarloRun.jason || teamB == MonteCarloRun.ross) {
					return -1;
				}
			} else if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()) {
				if (teamB == MonteCarloRun.brad) {
					return 1;
				} else {
					return getTylerJasonRossTiebreaker(teamA, teamB);
				}
			} else if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()) {
				if (teamB == MonteCarloRun.brad) {
					return 1;
				} else {
					return getTylerBradRossTiebreaker(teamA, teamB);
				}

			} else if (MonteCarloRun.ross.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.ross.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.ross.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
				if (teamB == MonteCarloRun.ross) {
					return 1;
				} else {
					return getTylerBradJasonTiebreaker(teamA, teamB);
				}
			}
		} else if (MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.brad.getTotalWins()
				&& MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.seth.getTotalWins()) {
			return getTylerBradSethTiebreaker(teamA, teamB);
		} else if (MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.jason.getTotalWins()
				&& MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.ross.getTotalWins()) {
			return getTylerJasonRossTiebreaker(teamA, teamB);
		} else if (MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.jason.getTotalWins()
				&& MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.seth.getTotalWins()) {
			return getTylerJasonSethTiebreaker(teamA, teamB);
		} else if (MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.brad.getTotalWins()
				&& MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.aaron.getTotalWins()) {
			return getTylerAaronBradTiebreaker(teamA, teamB);
		} else if (MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.brad.getTotalWins()
				&& MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.jason.getTotalWins()) {
			if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
				if (teamB == MonteCarloRun.brad || teamB == MonteCarloRun.jason) {
					return -1;
				}
			} else if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
				if (teamB == MonteCarloRun.brad) {
					return 1;
				} else if (teamB == MonteCarloRun.jason) {
					return getPointsTiebreaker(teamA, teamB);
				}
			} else {
				if (teamB == MonteCarloRun.brad || teamB == MonteCarloRun.jason) {
					return 1;
				}
			}
		} else if (MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.jackie.getTotalWins()
				&& MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.aaron.getTotalWins()) {
			if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()) {
				if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.jackie) {
					return -1;
				}
			} else if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()) {
				if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.aaron) {
					return 1;
				}
			} else {
				if (teamB == MonteCarloRun.aaron) {
					return 1;
				} else if (teamB == MonteCarloRun.jackie) {
					return -1;
				}
			}
		} else if (MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.jackie.getTotalWins()
				&& MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.brad.getTotalWins()) {
			return getTylerBradJackieTiebreaker(teamA, teamB);
		} else if (MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.aaron.getTotalWins()
				&& MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.jason.getTotalWins()) {
			return getTylerAaronJasonTiebreaker(teamA, teamB);
		}
		if (MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.aaron.getTotalWins()
				&& MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.seth.getTotalWins()) {
			return getTylerAaronSethTiebreaker(teamA, teamB);
		} else if (MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.aaron.getTotalWins()) {
			if (teamB == MonteCarloRun.aaron) {
				return 1;
			}
		} else if (MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.brad.getTotalWins()) {
			if (teamB == MonteCarloRun.brad) {
				return 1;
			}
		} else if (MonteCarloRun.tyler.getTotalWins() == MonteCarloRun.jason.getTotalWins()) {
			if (teamB == MonteCarloRun.jason) {
				return getPointsTiebreaker(teamA, teamB);
			}
		} else if (teamB == MonteCarloRun.seth || teamB == MonteCarloRun.jackie) {
			return -1;
		}
		return getError(teamA, teamB);
	}

	private int getTylerJasonSethTiebreaker(Team teamA, Team teamB) {
		if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
				&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
			return -1;
		} else if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
				&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
			if (teamB == MonteCarloRun.jason) {
				return 1;
			} else if (teamB == MonteCarloRun.seth) {
				return -1;
			}
		} else {
			if (teamB == MonteCarloRun.seth) {
				return 1;
			} else if (teamB == MonteCarloRun.jason) {
				return getPointsTiebreaker(teamA, teamB);
			}
		}
		return getError(teamA, teamB);
	}

	private int getTylerBradRossTiebreaker(Team teamA, Team teamB) {
		if (teamB == MonteCarloRun.brad || teamB == MonteCarloRun.ross) {
			return 1;
		}
		return getError(teamA, teamB);
	}

	private int getTylerBradJackieTiebreaker(Team teamA, Team teamB) {
		if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
				&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()) {
			if (teamB == MonteCarloRun.brad || teamB == MonteCarloRun.jackie) {
				return -1;
			}
		} else if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
				&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()) {
			if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.brad) {
				return 1;
			}
		} else {
			if (teamB == MonteCarloRun.brad) {
				return 1;
			} else if (teamB == MonteCarloRun.jackie) {
				return -1;
			}
		}
		return getError(teamA, teamB);
	}

	private int getTylerBradSethTiebreaker(Team teamA, Team teamB) {
		if (teamB == MonteCarloRun.brad) {
			return 1;
		} else if (teamB == MonteCarloRun.seth) {
			return -1;
		}
		return getError(teamA, teamB);
	}

	private int getTylerJackieSethTiebreaker(Team teamA, Team teamB) {
		if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
				&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
			if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.seth) {
				return -1;
			}
		} else if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
				&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
			if (teamB == MonteCarloRun.jackie) {
				return 1;
			} else if (teamB == MonteCarloRun.seth) {
				return -1;
			}
		} else {
			if (teamB == MonteCarloRun.seth) {
				return 1;
			} else if (teamB == MonteCarloRun.jackie) {
				return -1;
			}
		}
		return getError(teamA, teamB);
	}

	private int getTylerAaronBradTiebreaker(Team teamA, Team teamB) {
		if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
				&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()) {
			if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.brad) {
				return -1;
			}
		} else if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.brad) {
			return 1;
		}
		return getError(teamA, teamB);
	}

	private int getTylerAaronJasonTiebreaker(Team teamA, Team teamB) {
		if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
				&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
			if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.jason) {
				return -1;
			}
		} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
				&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
			if (teamB == MonteCarloRun.aaron) {
				return 1;
			} else if (teamB == MonteCarloRun.jason) {
				return getPointsTiebreaker(teamA, teamB);
			}
		} else {
			if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.jason) {
				return 1;
			}
		}
		return getError(teamA, teamB);
	}

	private int getTylerBradJasonSethTiebreaker(Team teamA, Team teamB) {
		if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
				&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
				&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
			if (teamB == MonteCarloRun.seth || teamB == MonteCarloRun.brad || teamB == MonteCarloRun.jason) {
				return -1;
			}
		} else if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
				&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
				&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
			if (teamB == MonteCarloRun.seth) {
				return 1;
			} else {
				return getTylerBradJasonTiebreaker(teamA, teamB);
			}
		}
		return getError(teamA, teamB);
	}

	private int getTylerBradJasonTiebreaker(Team teamA, Team teamB) {
		if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
				&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
			if (teamB == MonteCarloRun.ross || teamB == MonteCarloRun.jason) {
				return -1;
			}
		} else if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
				&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
			if (teamB == MonteCarloRun.brad) {
				return 1;
			} else if (teamB == MonteCarloRun.jason) {
				return getPointsTiebreaker(teamA, teamB);
			}
		} else {
			if (teamB == MonteCarloRun.jason || teamB == MonteCarloRun.brad) {
				return 1;
			}
		}
		return getError(teamA, teamB);
	}

	private int getTylerJasonRossTiebreaker(Team teamA, Team teamB) {
		if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
				&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()) {
			if (teamB == MonteCarloRun.jason || teamB == MonteCarloRun.ross) {
				return -1;
			}
		} else if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
				&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.ross.getProjectedPoints()) {
			if (teamB == MonteCarloRun.jason || teamB == MonteCarloRun.ross) {
				return 1;
			}
		}
		return getError(teamA, teamB);
	}

	private int getTylerAaronSethTiebreaker(Team teamA, Team teamB) {
		if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
				&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
			return -1;
		} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
				&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
			if (teamB == MonteCarloRun.aaron) {
				return 1;
			} else if (teamB == MonteCarloRun.seth) {
				return -1;
			}
		} else {
			if (teamB == MonteCarloRun.seth || teamB == MonteCarloRun.aaron) {
				return 1;
			}
		}
		return getError(teamA, teamB);
	}

	private int handleSethTiebreakers(Team teamA, Team teamB) {

		if (MonteCarloRun.seth.getTotalWins() == MonteCarloRun.brad.getTotalWins()
				&& MonteCarloRun.seth.getTotalWins() == MonteCarloRun.aaron.getTotalWins()
				&& MonteCarloRun.seth.getTotalWins() == MonteCarloRun.jason.getTotalWins()
				&& MonteCarloRun.seth.getTotalWins() == MonteCarloRun.tyler.getTotalWins()) {
			if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.brad || teamB == MonteCarloRun.jason
						|| teamB == MonteCarloRun.tyler) {
					return -1;
				}
			} else if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.brad) {
					return 1;
				} else {
					return getSethTylerJasonTiebreaker(teamA, teamB);
				}
			} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.aaron) {
					return 1;
				} else {
					return getSethBradJasonTylerTiebreaker(teamA, teamB);
				}
			} else if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
					&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.jason) {
					return 1;
				} else {
					return getSethAaronBradTylerTiebreaker(teamA, teamB);
				}
			} else if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()) {
				if (teamB == MonteCarloRun.tyler) {
					return 1;
				} else {
					return getSethAaronBradJasonTiebreaker(teamA, teamB);
				}
			}
		} else if (MonteCarloRun.seth.getTotalWins() == MonteCarloRun.brad.getTotalWins()
				&& MonteCarloRun.seth.getTotalWins() == MonteCarloRun.jason.getTotalWins()
				&& MonteCarloRun.seth.getTotalWins() == MonteCarloRun.tyler.getTotalWins()) {
			return getSethBradJasonTylerTiebreaker(teamA, teamB);
		}
		if (MonteCarloRun.seth.getTotalWins() == MonteCarloRun.aaron.getTotalWins()
				&& MonteCarloRun.seth.getTotalWins() == MonteCarloRun.jason.getTotalWins()
				&& MonteCarloRun.seth.getTotalWins() == MonteCarloRun.tyler.getTotalWins()) {
			return getSethAaronJasonTylerTiebreaker(teamA, teamB);
		} else if (MonteCarloRun.seth.getTotalWins() == MonteCarloRun.aaron.getTotalWins()
				&& MonteCarloRun.seth.getTotalWins() == MonteCarloRun.jackie.getTotalWins()
				&& MonteCarloRun.seth.getTotalWins() == MonteCarloRun.tyler.getTotalWins()) {
			if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.tyler) {
					return -1;
				}
			} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.aaron) {
					return 1;
				} else {
					if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
							&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()) {
						if (teamB == MonteCarloRun.tyler || teamB == MonteCarloRun.jackie) {
							return -1;
						}
					} else if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
							&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
						if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.tyler) {
							return 1;
						}
					} else {
						if (teamB == MonteCarloRun.jackie) {
							return 1;
						} else if (teamB == MonteCarloRun.tyler) {
							return 1;
						}
					}
				}
			} else if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
					&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.jackie) {
					return 1;
				} else {
					if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
							&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
						if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.tyler) {
							return -1;
						}
					} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
							&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
						if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.tyler) {
							return 1;
						}
					} else {
						if (teamB == MonteCarloRun.tyler) {
							return 1;
						} else if (teamB == MonteCarloRun.aaron) {
							return -1;
						}
					}
				}
			} else if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()) {
				if (teamB == MonteCarloRun.tyler) {
					return 1;
				} else {
					if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.aaron) {
						return -1;
					}
				}
			}
		} else if (MonteCarloRun.seth.getTotalWins() == MonteCarloRun.aaron.getTotalWins()
				&& MonteCarloRun.seth.getTotalWins() == MonteCarloRun.brad.getTotalWins()
				&& MonteCarloRun.seth.getTotalWins() == MonteCarloRun.tyler.getTotalWins()) {
			return getSethAaronBradTylerTiebreaker(teamA, teamB);
		} else if (MonteCarloRun.seth.getTotalWins() == MonteCarloRun.aaron.getTotalWins()
				&& MonteCarloRun.seth.getTotalWins() == MonteCarloRun.brad.getTotalWins()
				&& MonteCarloRun.seth.getTotalWins() == MonteCarloRun.jason.getTotalWins()) {
			return getSethAaronBradJasonTiebreaker(teamA, teamB);
		} else if (MonteCarloRun.seth.getTotalWins() == MonteCarloRun.brad.getTotalWins()
				&& MonteCarloRun.seth.getTotalWins() == MonteCarloRun.jackie.getTotalWins()
				&& MonteCarloRun.seth.getTotalWins() == MonteCarloRun.tyler.getTotalWins()) {
			if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.brad || teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.tyler) {
					return -1;
				}
			} else if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.brad) {
					return 1;
				} else {
					if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
							&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()) {
						if (teamB == MonteCarloRun.tyler || teamB == MonteCarloRun.jackie) {
							return -1;
						}
					} else if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
							&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
						if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.tyler) {
							return 1;
						}
					} else {
						if (teamB == MonteCarloRun.jackie) {
							return 1;
						} else if (teamB == MonteCarloRun.tyler) {
							return 1;
						}
					}
				}
			} else if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
					&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.jackie) {
					return 1;
				} else {
					return getSethBradTylerTiebreaker(teamA, teamB);

				}
			} else if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()) {
				if (teamB == MonteCarloRun.tyler) {
					return 1;
				} else {
					return getSethBradJackieTiebreaker(teamA, teamB);

				}
			}
		} else if (MonteCarloRun.seth.getTotalWins() == MonteCarloRun.brad.getTotalWins()
				&& MonteCarloRun.seth.getTotalWins() == MonteCarloRun.jason.getTotalWins()) {
			return getSethBradJasonTiebreaker(teamA, teamB);
		} else if (MonteCarloRun.seth.getTotalWins() == MonteCarloRun.aaron.getTotalWins()
				&& MonteCarloRun.seth.getTotalWins() == MonteCarloRun.brad.getTotalWins()) {
			return getSethAaronBradTiebreaker(teamA, teamB);
		} else if (MonteCarloRun.seth.getTotalWins() == MonteCarloRun.brad.getTotalWins()
				&& MonteCarloRun.seth.getTotalWins() == MonteCarloRun.tyler.getTotalWins()) {
			return getSethBradTylerTiebreaker(teamA, teamB);
		} else if (MonteCarloRun.seth.getTotalWins() == MonteCarloRun.tyler.getTotalWins()
				&& MonteCarloRun.seth.getTotalWins() == MonteCarloRun.jason.getTotalWins()) {
			return getSethTylerJasonTiebreaker(teamA, teamB);
		} else if (MonteCarloRun.seth.getTotalWins() == MonteCarloRun.tyler.getTotalWins()
				&& MonteCarloRun.seth.getTotalWins() == MonteCarloRun.aaron.getTotalWins()) {
			if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()) {
				if (teamB == MonteCarloRun.tyler || teamB == MonteCarloRun.aaron) {
					return -1;
				}
			} else if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()) {
				if (teamB == MonteCarloRun.tyler) {
					return 1;
				} else if (teamB == MonteCarloRun.aaron) {
					return -1;
				}
			} else {
				if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.tyler) {
					return 1;
				}
			}
		}
		if (MonteCarloRun.seth.getTotalWins() == MonteCarloRun.brad.getTotalWins()
				&& MonteCarloRun.seth.getTotalWins() == MonteCarloRun.jackie.getTotalWins()) {
			return getSethBradJackieTiebreaker(teamA, teamB);
		} else if (MonteCarloRun.seth.getTotalWins() == MonteCarloRun.jackie.getTotalWins()
				&& MonteCarloRun.seth.getTotalWins() == MonteCarloRun.aaron.getTotalWins()) {
			if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.aaron) {
				return -1;
			}
		} else if (MonteCarloRun.seth.getTotalWins() == MonteCarloRun.brad.getTotalWins()) {
			if (teamB == MonteCarloRun.brad) {
				return 1;
			}
		} else if (MonteCarloRun.seth.getTotalWins() == MonteCarloRun.aaron.getTotalWins()) {
			if (teamB == MonteCarloRun.aaron) {
				return -1;
			}
		} else if (teamB == MonteCarloRun.jackie) {
			return -1;
		} else if (teamB == MonteCarloRun.tyler) {
			return 1;
		} else if (teamB == MonteCarloRun.jason) {
			return getPointsTiebreaker(teamA, teamB);
		}
		return getError(teamA, teamB);
	}

	private int getSethAaronBradJasonTiebreaker(Team teamA, Team teamB) {
		if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
				&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
				&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()) {
			if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.jason || teamB == MonteCarloRun.brad) {
				return -1;
			}
		} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
				&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
				&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()) {
			if (teamB == MonteCarloRun.aaron) {
				return 1;
			} else {
				return getSethBradJasonTiebreaker(teamA, teamB);
			}
		} else if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
				&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
				&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()) {
			if (teamB == MonteCarloRun.jason) {
				return 1;
			} else {
				return getSethAaronBradTiebreaker(teamA, teamB);
			}
		} else if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
				&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
				&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
			if (teamB == MonteCarloRun.tyler) {
				return 1;
			} else {
				if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
						&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
					if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.jason) {
						return -1;
					}
				} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
						&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
					if (teamB == MonteCarloRun.aaron) {
						return 1;
					} else if (teamB == MonteCarloRun.jason) {
						return getPointsTiebreaker(teamA, teamB);
					}
				} else {
					if (teamB == MonteCarloRun.jason) {
						return 1;
					} else if (teamB == MonteCarloRun.aaron) {
						return -1;
					}
				}
			}
		}
		return getError(teamA, teamB);
	}

	private int getSethAaronBradTylerTiebreaker(Team teamA, Team teamB) {
		if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
				&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
				&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
			if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.brad || teamB == MonteCarloRun.tyler) {
				return -1;
			}
		} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
				&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
				&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
			if (teamB == MonteCarloRun.aaron) {
				return 1;
			} else {
				return getSethBradTylerTiebreaker(teamA, teamB);
			}
		} else if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
				&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
				&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
			if (teamB == MonteCarloRun.brad) {
				return 1;
			} else {

				if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
						&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
					if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.tyler) {
						return -1;
					}
				} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
						&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
					if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.tyler) {
						return 1;
					}
				} else {
					if (teamB == MonteCarloRun.tyler) {
						return 1;
					} else if (teamB == MonteCarloRun.aaron) {
						return -1;
					}
				}
			}
		} else if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
				&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
				&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()) {
			if (teamB == MonteCarloRun.tyler) {
				return 1;
			} else {
				return getSethAaronBradTiebreaker(teamA, teamB);
			}
		}
		return getError(teamA, teamB);
	}

	private int getSethAaronBradTiebreaker(Team teamA, Team teamB) {
		if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
				&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()) {
			if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.brad) {
				return -1;
			}
		} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
				&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()) {
			if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.brad) {
				return 1;
			}
		} else {
			if (teamB == MonteCarloRun.brad) {
				return 1;
			} else if (teamB == MonteCarloRun.aaron) {
				return -1;
			}
		}
		return getError(teamA, teamB);
	}

	private int getSethBradJackieTiebreaker(Team teamA, Team teamB) {
		if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
				&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()) {
			if (teamB == MonteCarloRun.brad || teamB == MonteCarloRun.jackie) {
				return -1;
			}
		} else if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
				&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()) {
			if (teamB == MonteCarloRun.brad) {
				return 1;
			} else if (teamB == MonteCarloRun.jackie) {
				return -1;
			}
		} else {
			if (teamB == MonteCarloRun.brad || teamB == MonteCarloRun.jackie) {
				return 1;
			}
		}
		return getError(teamA, teamB);
	}

	private int getSethBradJasonTylerTiebreaker(Team teamA, Team teamB) {
		if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
				&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
				&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
			if (teamB == MonteCarloRun.brad || teamB == MonteCarloRun.jason || teamB == MonteCarloRun.tyler) {
				return -1;
			}
		} else if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
				&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
				&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
			if (teamB == MonteCarloRun.brad) {
				return 1;
			} else {
				return getSethTylerJasonTiebreaker(teamA, teamB);
			}
		} else if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
				&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
				&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
			if (teamB == MonteCarloRun.jason) {
				return 1;
			} else {
				return getSethBradTylerTiebreaker(teamA, teamB);
			}
		} else if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
				&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
				&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
			if (teamB == MonteCarloRun.tyler) {
				return 1;
			} else {
				return getSethBradJasonTiebreaker(teamA, teamB);
			}
		}
		return getError(teamA, teamB);
	}

	private int getSethBradJasonTiebreaker(Team teamA, Team teamB) {
		if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
				&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
			if (teamB == MonteCarloRun.brad || teamB == MonteCarloRun.jason) {
				return -1;
			}
		} else if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
				&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()) {
			if (teamB == MonteCarloRun.jason || teamB == MonteCarloRun.brad) {
				return 1;
			}
		} else {
			if (teamB == MonteCarloRun.jason) {
				return getPointsTiebreaker(teamA, teamB);
			} else if (teamB == MonteCarloRun.brad) {
				return 1;
			}
		}
		return getError(teamA, teamB);
	}

	private int getSethBradTylerTiebreaker(Team teamA, Team teamB) {
		if (teamB == MonteCarloRun.brad || teamB == MonteCarloRun.tyler) {
			return 1;
		}
		return getError(teamA, teamB);
	}

	private int getSethAaronJasonTylerTiebreaker(Team teamA, Team teamB) {
		if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
				&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
				&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
			if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.jason || teamB == MonteCarloRun.tyler) {
				return -1;
			}
		} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
				&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
				&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
			if (teamB == MonteCarloRun.aaron) {
				return 1;
			} else {
				return getSethTylerJasonTiebreaker(teamA, teamB);
			}
		} else if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
				&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
				&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
			if (teamB == MonteCarloRun.jason) {
				return 1;
			} else {
				if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
						&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
					if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.tyler) {
						return -1;
					}
				} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
						&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
					if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.tyler) {
						return 1;
					}
				} else {
					if (teamB == MonteCarloRun.tyler) {
						return 1;
					} else if (teamB == MonteCarloRun.aaron) {
						return -1;
					}
				}
			}
		} else if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
				&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
				&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()) {
			if (teamB == MonteCarloRun.tyler) {
				return 1;
			} else {
				if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
						&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
					if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.jason) {
						return -1;
					}
				} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
						&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
					if (teamB == MonteCarloRun.aaron) {
						return 1;
					} else if (teamB == MonteCarloRun.jason) {
						return getPointsTiebreaker(teamA, teamB);
					}
				} else {
					if (teamB == MonteCarloRun.jason) {
						return 1;
					} else if (teamB == MonteCarloRun.aaron) {
						return -1;
					}
				}
			}
		}
		return getError(teamA, teamB);
	}

	private int getSethTylerJasonTiebreaker(Team teamA, Team teamB) {
		if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()
				&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()) {
			return getBradJasonTylerTiebreaker(teamA, teamB);
		} else if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
				&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
			if (teamB == MonteCarloRun.jason || teamB == MonteCarloRun.tyler) {
				return 1;
			}
		} else {
			if (teamB == MonteCarloRun.jason) {
				return getPointsTiebreaker(teamA, teamB);
			} else if (teamB == MonteCarloRun.tyler) {
				return 1;
			}
		}
		return getError(teamA, teamB);
	}

	private int handleBradTiebreakers(Team teamA, Team teamB) {
		if (MonteCarloRun.brad.getTotalWins() == MonteCarloRun.jason.getTotalWins()
				&& MonteCarloRun.brad.getTotalWins() == MonteCarloRun.seth.getTotalWins()
				&& MonteCarloRun.brad.getTotalWins() == MonteCarloRun.tyler.getTotalWins()) {
			if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.jason || teamB == MonteCarloRun.seth || teamB == MonteCarloRun.tyler) {
					return -1;
				}
			} else if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
					&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.jason) {
					return 1;
				} else {
					return getBradSethTylerTiebreaker(teamA, teamB);
				}
			} else if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.seth) {
					return 1;
				} else {
					return getBradJasonTylerTiebreaker(teamA, teamB);
				}
			} else {
				if (teamB == MonteCarloRun.tyler) {
					return 1;
				} else {
					return getBradJasonSethTiebreaker(teamA, teamB);
				}
			}
		} else if (MonteCarloRun.brad.getTotalWins() == MonteCarloRun.aaron.getTotalWins()
				&& MonteCarloRun.brad.getTotalWins() == MonteCarloRun.jackie.getTotalWins()
				&& MonteCarloRun.brad.getTotalWins() == MonteCarloRun.tyler.getTotalWins()) {
			if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.tyler) {
					return -1;
				}
			} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.aaron) {
					return 1;
				} else {
					return getBradJackieTylerTiebreaker(teamA, teamB);
				}
			} else if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.jackie) {
					return 1;
				} else {
					return getBradAaronTylerTiebreaker(teamA, teamB);
				}
			} else {
				if (teamB == MonteCarloRun.tyler) {
					return 1;
				} else {
					if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
							&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()) {
						if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.jackie) {
							return -1;
						}
					} else {
						if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.jackie) {
							return 1;
						}
					}
				}
			}
		} else if (MonteCarloRun.brad.getTotalWins() == MonteCarloRun.jackie.getTotalWins()
				&& MonteCarloRun.brad.getTotalWins() == MonteCarloRun.seth.getTotalWins()
				&& MonteCarloRun.brad.getTotalWins() == MonteCarloRun.tyler.getTotalWins()) {
			if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.seth || teamB == MonteCarloRun.tyler) {
					return -1;
				}
			} else if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
					&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.jackie) {
					return 1;
				} else {
					return getBradSethTylerTiebreaker(teamA, teamB);
				}
			} else if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.seth) {
					return 1;
				} else {
					return getBradJackieTylerTiebreaker(teamA, teamB);
				}
			} else {
				if (teamB == MonteCarloRun.tyler) {
					return 1;
				} else {

					if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
							&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
						if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.seth) {
							return -1;
						}
					} else {
						if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
								&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.seth
										.getProjectedPoints()) {
							if (teamB == MonteCarloRun.jackie) {
								return 1;
							} else if (teamB == MonteCarloRun.seth) {
								return -1;
							}
						} else {
							if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.seth) {
								return 1;
							}
						}
					}
				}
			}
		}
		if (MonteCarloRun.brad.getTotalWins() == MonteCarloRun.aaron.getTotalWins()
				&& MonteCarloRun.brad.getTotalWins() == MonteCarloRun.seth.getTotalWins()) {
			if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.seth) {
					return -1;
				}
			} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.seth) {
					return -1;
				} else if (teamB == MonteCarloRun.aaron) {
					return 1;
				}
			} else {
				if (teamB == MonteCarloRun.aaron) {
					return getBillyVsAaron(teamA, teamB);
				} else if (teamB == MonteCarloRun.seth) {
					return 1;
				}
			}
		}
		if (MonteCarloRun.brad.getTotalWins() == MonteCarloRun.jason.getTotalWins()
				&& MonteCarloRun.brad.getTotalWins() == MonteCarloRun.seth.getTotalWins()) {
			return getBradJasonSethTiebreaker(teamA, teamB);
		} else if (MonteCarloRun.brad.getTotalWins() == MonteCarloRun.aaron.getTotalWins()
				&& MonteCarloRun.brad.getTotalWins() == MonteCarloRun.tyler.getTotalWins()) {
			return getBradAaronTylerTiebreaker(teamA, teamB);
		} else if (MonteCarloRun.brad.getTotalWins() == MonteCarloRun.jackie.getTotalWins()
				&& MonteCarloRun.brad.getTotalWins() == MonteCarloRun.tyler.getTotalWins()) {
			return getBradJackieTylerTiebreaker(teamA, teamB);
		} else if (MonteCarloRun.brad.getTotalWins() == MonteCarloRun.tyler.getTotalWins()
				&& MonteCarloRun.brad.getTotalWins() == MonteCarloRun.seth.getTotalWins()) {
			return getBradSethTylerTiebreaker(teamA, teamB);
		} else if (MonteCarloRun.brad.getTotalWins() == MonteCarloRun.tyler.getTotalWins()
				&& MonteCarloRun.brad.getTotalWins() == MonteCarloRun.jason.getTotalWins()) {
			return getBradJasonTylerTiebreaker(teamA, teamB);
		} else if (teamB == MonteCarloRun.seth || teamB == MonteCarloRun.tyler || teamB == MonteCarloRun.jason) {
			return -1;
		} else if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.aaron) {
			return 1;
		}
		return getError(teamA, teamB);
	}

	private int getBradAaronTylerTiebreaker(Team teamA, Team teamB) {
		if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
				&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
			if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.tyler) {
				return -1;
			}
		} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
				&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
			if (teamB == MonteCarloRun.tyler) {
				return -1;
			} else if (teamB == MonteCarloRun.aaron) {
				return 1;
			}
		} else {
			if (teamB == MonteCarloRun.aaron) {
				return getBillyVsAaron(teamA, teamB);
			} else if (teamB == MonteCarloRun.tyler) {
				return 1;
			}
		}
		return getError(teamA, teamB);
	}

	private int getBradJackieTylerTiebreaker(Team teamA, Team teamB) {
		if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
				&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
			if (teamB == MonteCarloRun.jackie || teamB == MonteCarloRun.tyler) {
				return -1;
			}
		} else if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
				&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
			if (teamB == MonteCarloRun.jackie) {
				return 1;
			} else if (teamB == MonteCarloRun.tyler) {
				return -1;
			}
		} else {
			if (teamB == MonteCarloRun.tyler || teamB == MonteCarloRun.jackie) {
				return 1;
			}
		}
		return getError(teamA, teamB);
	}

	private int getBradJasonSethTiebreaker(Team teamA, Team teamB) {
		if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.jason.getProjectedPoints()
				&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
			if (teamB == MonteCarloRun.jason || teamB == MonteCarloRun.seth) {
				return -1;
			}
		} else if (MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
				&& MonteCarloRun.jason.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
			if (teamB == MonteCarloRun.seth) {
				return -1;
			} else if (teamB == MonteCarloRun.jason) {
				return 1;
			}
		} else {
			if (teamB == MonteCarloRun.jason) {
				return -1;
			} else if (teamB == MonteCarloRun.seth) {
				return 1;
			}
		}
		return getError(teamA, teamB);
	}

	private int getBradJasonTylerTiebreaker(Team teamA, Team teamB) {
		if (teamB == MonteCarloRun.tyler || teamB == MonteCarloRun.jason) {
			return -1;
		}
		return getError(teamA, teamB);
	}

	private int getBradSethTylerTiebreaker(Team teamA, Team teamB) {
		if (teamB == MonteCarloRun.tyler || teamB == MonteCarloRun.seth) {
			return -1;
		}
		return getError(teamA, teamB);
	}

	private int getBillyVsAaron(Team teamA, Team teamB) {
		if (MonteCarloRun.billyOverAaron) {
			return getPointsTiebreaker(teamA, teamB);
		} else {
			return 1;
		}
	}

	private int getPointsTiebreaker(Team teamA, Team teamB) {
		if (teamA.getProjectedPoints() > teamB.getProjectedPoints()) {
			return -1;
		} else {
			return 1;
		}
	}

	private int handleJackieTiebreakers(Team teamA, Team teamB) {
		if (MonteCarloRun.jackie.getTotalWins() == MonteCarloRun.aaron.getTotalWins()
				&& MonteCarloRun.jackie.getTotalWins() == MonteCarloRun.seth.getTotalWins()
				&& MonteCarloRun.jackie.getTotalWins() == MonteCarloRun.tyler.getTotalWins()) {
			if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
					&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.seth || teamB == MonteCarloRun.tyler) {
					return -1;
				}
			} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.aaron) {
					return 1;
				} else if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
						&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
					if (teamB == MonteCarloRun.seth || teamB == MonteCarloRun.tyler) {
						return -1;
					}
				} else if (teamB == MonteCarloRun.seth || teamB == MonteCarloRun.tyler) {
					return 1;
				}
			} else if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.seth) {
					return 1;
				} else if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
						&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
					if(teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.tyler) {
						return -1;
					}
				} else if(MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
						&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
					if(teamB == MonteCarloRun.aaron || teamB== MonteCarloRun.tyler) {
						return 1;
					}
				} else if(MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
						&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()) {
					if(teamB == MonteCarloRun.tyler) {
						return 1;
					} else if(teamB == MonteCarloRun.aaron) {
						return -1;
					}
				}
			} else if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.tyler) {
					return 1;
				} else if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
						&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
					if(teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.seth) {
						return -1;
					}
				} else if(MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
						&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
						if(teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.seth) {
							return 1;
						}
				}  else if(MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
						&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()) {
						if(teamB == MonteCarloRun.seth) {
							return 1;
						} else if(teamB == MonteCarloRun.aaron) {
							return -1;
						}
				}
			}
		}
		if (MonteCarloRun.jackie.getTotalWins() == MonteCarloRun.aaron.getTotalWins()
				&& MonteCarloRun.jackie.getTotalWins() == MonteCarloRun.seth.getTotalWins()) {
			if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.seth) {
					return -1;
				}
			} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.seth) {
					return 1;
				}
			} else if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()) {
				if (teamB == MonteCarloRun.seth) {
					return 1;
				} else if (teamB == MonteCarloRun.aaron) {
					return -1;
				}
			}
		}
		if (MonteCarloRun.jackie.getTotalWins() == MonteCarloRun.aaron.getTotalWins()
				&& MonteCarloRun.jackie.getTotalWins() == MonteCarloRun.tyler.getTotalWins()) {
			if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()
					&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.tyler) {
					return -1;
				}
			} else if (MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.aaron.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.aaron || teamB == MonteCarloRun.tyler) {
					return 1;
				}
			} else if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.aaron.getProjectedPoints()) {
				if (teamB == MonteCarloRun.tyler) {
					return 1;
				} else if (teamB == MonteCarloRun.aaron) {
					return -1;
				}
			}
		} else if (MonteCarloRun.jackie.getTotalWins() == MonteCarloRun.brad.getTotalWins()
				&& MonteCarloRun.jackie.getTotalWins() == MonteCarloRun.tyler.getTotalWins()) {
			if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.brad || teamB == MonteCarloRun.tyler) {
					return -1;
				}
			} else if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.brad || teamB == MonteCarloRun.tyler) {
					return 1;
				}
			} else if (MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.tyler.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()) {
				if (teamB == MonteCarloRun.tyler) {
					return 1;
				} else if (teamB == MonteCarloRun.brad) {
					return -1;
				}
			}
		} else if (MonteCarloRun.jackie.getTotalWins() == MonteCarloRun.brad.getTotalWins()
				&& MonteCarloRun.jackie.getTotalWins() == MonteCarloRun.seth.getTotalWins()) {
			if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.brad || teamB == MonteCarloRun.seth) {
					return -1;
				}
			} else if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.brad || teamB == MonteCarloRun.seth) {
					return 1;
				}
			} else if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()) {
				if (teamB == MonteCarloRun.seth) {
					return 1;
				} else if (teamB == MonteCarloRun.brad) {
					return -1;
				}
			}
		} else if (MonteCarloRun.jackie.getTotalWins() == MonteCarloRun.brad.getTotalWins()
				&& MonteCarloRun.jackie.getTotalWins() == MonteCarloRun.seth.getTotalWins()) {
			if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()
					&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.brad || teamB == MonteCarloRun.seth) {
					return -1;
				}
			} else if (MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.brad.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()) {
				if (teamB == MonteCarloRun.brad || teamB == MonteCarloRun.seth) {
					return 1;
				}
			} else if (MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.jackie.getProjectedPoints()
					&& MonteCarloRun.seth.getProjectedPoints() > MonteCarloRun.brad.getProjectedPoints()) {
				if (teamB == MonteCarloRun.seth) {
					return 1;
				} else if (teamB == MonteCarloRun.brad) {
					return -1;
				}
			}
		}
		if (MonteCarloRun.jackie.getTotalWins() == MonteCarloRun.seth.getTotalWins()
				&& MonteCarloRun.jackie.getTotalWins() == MonteCarloRun.tyler.getTotalWins()) {
			if (MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.seth.getProjectedPoints()
					&& MonteCarloRun.jackie.getProjectedPoints() > MonteCarloRun.tyler.getProjectedPoints()) {
				if (teamB == MonteCarloRun.seth || teamB == MonteCarloRun.tyler) {
					return -1;
				}
			} else if (teamB == MonteCarloRun.seth || teamB == MonteCarloRun.tyler) {
				return 1;
			}
		} else if (MonteCarloRun.jackie.getTotalWins() == MonteCarloRun.brad.getTotalWins()) {
			if (teamB == MonteCarloRun.brad) {
				return -1;
			}
		} else if (MonteCarloRun.jackie.getTotalWins() == MonteCarloRun.nick.getTotalWins()) {
			if (teamB == MonteCarloRun.nick) {
				return getPointsTiebreaker(teamA, teamB);
			}
		} else if (MonteCarloRun.jackie.getTotalWins() == MonteCarloRun.aaron.getTotalWins()) {
			if (teamB == MonteCarloRun.aaron) {
				return -1;
			}
		} else if (MonteCarloRun.jackie.getTotalWins() == MonteCarloRun.joe.getTotalWins()) {
			if (teamB == MonteCarloRun.joe) {
				return -1;
			}
		} else if (teamB == MonteCarloRun.tyler) {
			return 1;
		} else if (teamB == MonteCarloRun.seth) {
			return 1;
		}
		return getError(teamA, teamB);
	}

}
